package io.github.btpka3.wx4j.com.api.impl

import io.github.btpka3.wx4j.com.api.ComAtApi
import io.github.btpka3.wx4j.com.api.ComAtApi.GetComAtReq
import io.github.btpka3.wx4j.com.api.ComAtApi.GetComAtResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class ComAtApiImpl implements ComAtApi {

    RestOperations restTemplate

    ComAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    GetComAtResp getComAt(GetComAtReq getComAtReq) {


        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URI_getComAt)
                .build()
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<GetComAtResp> reqEntity = new HttpEntity(getComAtReq, headers)

        ResponseEntity<GetComAtResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                GetComAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        GetComAtResp resp = respEntity.getBody()

        resp.check()

        return resp
    }
}
