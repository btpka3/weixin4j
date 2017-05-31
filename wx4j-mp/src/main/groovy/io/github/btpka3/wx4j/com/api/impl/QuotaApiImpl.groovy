package io.github.btpka3.wx4j.com.api.impl

import io.github.btpka3.wx4j.com.api.QuotaApi
import io.github.btpka3.wx4j.com.api.QuotaApi.ClearResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class QuotaApiImpl implements QuotaApi {

    RestOperations restTemplate

    QuotaApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    ClearResp clear(String component_access_token, ClearResp clearReq) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URI_clear)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<ClearResp> reqEntity = new HttpEntity(clearReq, headers)

        ResponseEntity<ClearResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                ClearResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        ClearResp resp = respEntity.getBody()

        resp.check()

        return resp
    }
}
