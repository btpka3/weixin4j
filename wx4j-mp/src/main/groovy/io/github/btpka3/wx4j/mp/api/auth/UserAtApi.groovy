package io.github.btpka3.wx4j.mp.api.auth

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 获取 用户授权的 access_token
 */
@CompileStatic
interface UserAtApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/sns/oauth2/access_token"

    static class Query {


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
