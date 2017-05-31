package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.api.SnsUserApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

import static io.github.btpka3.wx4j.mp.api.SnsUserApi.InfoResp

/**
 *
 */
class SnsUserApiImpl implements SnsUserApi {


    RestOperations restTemplate

    SnsUserApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    InfoResp info(String access_token, String openid, String lang) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_info)
                .queryParam('access_token', access_token)
                .queryParam('openid', openid)
                .queryParam('lang', lang)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<InfoResp> respEntity = restTemplate.getForEntity(uri, InfoResp)
        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        InfoResp resp = respEntity.body

        resp.check()

        return resp
    }
}
