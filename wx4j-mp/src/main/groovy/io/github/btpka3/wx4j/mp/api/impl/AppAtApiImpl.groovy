package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.api.AppAtApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class AppAtApiImpl implements AppAtApi {

    RestOperations restTemplate

    AppAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    AppAtApi.GetAppAtResp getAppAt(String grant_type, String appid, String secret) {

        // client_credential
        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_getAppAt)
                .queryParam('grant_type', grant_type)
                .queryParam('appid', appid)
                .queryParam('secret', secret)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<AppAtApi.GetAppAtResp> respEntity = restTemplate.getForEntity(uri, AppAtApi.GetAppAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                " 获取微信AccessToken 失败， 响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "获取微信AccessToken 失败，响应内容为空")

        AppAtApi.GetAppAtResp resp = respEntity.body
        return resp
    }
}
