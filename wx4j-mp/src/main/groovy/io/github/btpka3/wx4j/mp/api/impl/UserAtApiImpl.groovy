package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.api.UserAtApi
import io.github.btpka3.wx4j.mp.api.UserAtApi.GetUserAtResp
import io.github.btpka3.wx4j.mp.api.UserAtApi.IsValidResp
import io.github.btpka3.wx4j.mp.api.UserAtApi.RefreshResp
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class UserAtApiImpl implements UserAtApi {

    RestOperations restTemplate

    UserAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }


    @Override
    String createUserAuthUrl(
            String appid,
            String redirect_uri,
//            String response_type,
            String scope,
            String state
    ) {
        URI uri = UriComponentsBuilder.fromHttpUrl(API_URL_createAuthUrl)
                .queryParam('appid', appid)
                .queryParam('redirect_uri', redirect_uri)
                .queryParam('response_type', "code")
                .queryParam('scope', scope)
                .queryParam('state', state)
                .build()
                .encode("UTF-8")
                .toUri()

        return uri.toString()
    }

    @Override
    IsValidResp isValid(String access_token, String openid) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_isValid)
                .queryParam('access_token', access_token)
                .queryParam('openid', openid)
                .build()
                .encode("UTF-8")
                .toUri()


        ResponseEntity<IsValidResp> respEntity = restTemplate.getForEntity(uri, IsValidResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        IsValidResp resp = respEntity.body

        resp.check()

        return resp
    }

    @Override
    RefreshResp refresh(
            String appid,
//            String grant_type,
            String refresh_token
    ) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_refresh)
                .queryParam('appid', appid)
                .queryParam('grant_type', "refresh_token")
                .queryParam('refresh_token', refresh_token)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<RefreshResp> respEntity = restTemplate.getForEntity(uri, RefreshResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        RefreshResp resp = respEntity.body

        resp.check()

        return resp
    }

    /**
     * 通过 code 换取用户级别的 access token。
     *
     * @param appid
     * @param secret
     * @param code
     * @param grant_type
     * @return
     */
    @Override
    GetUserAtResp getUserAt(
            String appid,
            String secret,
            String code
//            String grant_type
    ) {
        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_getUserAt)
                .queryParam('appid', appid)
                .queryParam('secret', secret)
                .queryParam('code', code)
                .queryParam('grant_type', "authorization_code")
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<GetUserAtResp> respEntity = restTemplate.getForEntity(uri, GetUserAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        GetUserAtResp resp = respEntity.body

        resp.check()

        return resp
    }
}
