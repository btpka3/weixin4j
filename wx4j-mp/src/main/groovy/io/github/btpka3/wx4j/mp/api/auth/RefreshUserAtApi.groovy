package io.github.btpka3.wx4j.mp.api.auth

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.WxMpApi

/**
 * 刷新用户 access_token（如果需要）
 */
@CompileStatic
interface RefreshUserAtApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/sns/oauth2/refresh_token"

    static class Query {

        /**
         * 公众号的唯一标识
         */
        String appid

        /**
         * 授权类型。
         *
         * 填写为 "refresh_token"
         */
        String grant_type = "refresh_token"

        String refresh_token
    }

    static class Resp {

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
}
