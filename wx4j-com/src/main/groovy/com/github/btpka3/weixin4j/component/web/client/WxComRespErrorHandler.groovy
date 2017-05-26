package com.github.btpka3.weixin4j.component.web.client

import groovy.json.JsonSlurper
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.ResponseErrorHandler

/**
 *
 */
class WxComRespErrorHandler implements ResponseErrorHandler {

    //@Delegate
    ResponseErrorHandler delegate

    WxComRespErrorHandler(ResponseErrorHandler delegate) {
        this.delegate = delegate
    }

    boolean hasError(ClientHttpResponse response) {
        if (this.delegate.hasError(response)) {
            return true
        }

        Object jsonResult = new JsonSlurper().parseText(response.getBody()?.text)

        return jsonResult?.errcode as boolean

    }

    void handleError(ClientHttpResponse response) {
        this.delegate.handleError(response)

        Object jsonResult = new JsonSlurper().parseText(response.getBody()?.text)
        throw new WxComApiException(jsonResult?.errcode, jsonResult?.errmsg);
    }
}
