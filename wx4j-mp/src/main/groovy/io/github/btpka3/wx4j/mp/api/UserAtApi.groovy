package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.WxMpApi
import io.github.btpka3.wx4j.mp.api.BaseResp

/**
 * 获取 用户授权的 access_token
 */
@CompileStatic
interface UserAtApi extends WxMpApi {

    static final String API_URI_isValid = "https://api.weixin.qq.com/sns/auth"

    static final String API_URI_getUserAt = "https://api.weixin.qq.com/sns/oauth2/access_token"

    static final String API_URI_refresh = "https://api.weixin.qq.com/sns/oauth2/refresh_token"

    IsValidResp isValid(String access_token, String openid)


    RefreshResp refresh(String appid, String grant_type, String refresh_token)

    // grant_type = "authorization_code"
    GetUserAtResp getUserAt(String appid, String secret, String code, String grant_type)


    static class RefreshResp extends BaseResp {
        /**
         * 网页授权接口调用凭证
         */
        String access_token

        /**
         * access_token接口调用凭证超时时间，单位（秒）
         */
        int expires_in

        /**
         * 用户刷新access_token
         */
        String refresh_token

        /**
         * 用户唯一标识
         */
        String openid

        /**
         * 用户授权的作用域，使用逗号（,）分隔
         */
        String scope
    }

    static class IsValidResp extends BaseResp {
    }


    static class GetUserAtResp extends BaseResp {

        /**
         * 公众号的唯一标识
         */
        String appid

        /**
         * 公众号的appsecret
         */
        String secret

        /**
         * 代表用户授权的 code。
         *
         * 只能使用一次，用以换取用户的 access token
         */
        String code

        /**
         * 授权类型。
         *
         * 填写为 "authorization_code"
         */
        String grant_type = "authorization_code"
    }

    static class Resp {

        String access_token

    }
}
