package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.api.JsApiTicketApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

import static io.github.btpka3.wx4j.mp.api.JsApiTicketApi.GetTicketResp

/**
 *
 */
class JsApiTicketApiImpl implements JsApiTicketApi {


    RestOperations restTemplate

    JsApiTicketApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    GetTicketResp getTicket(String access_token) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_getTicket)
                .queryParam('access_token', access_token)
                .queryParam('type', "jsapi")
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<GetTicketResp> respEntity = restTemplate.getForEntity(uri, GetTicketResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        GetTicketResp resp = respEntity.body

        Assert.isTrue(resp.errcode == null || resp.errcode == 0,
                resp.errmsg ?: "调用微信API异常，错误码 - " + resp.errcode)

        return resp
    }
}
