package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
 */
@CompileStatic
interface AuthorizerTokenApi extends WxComApi<Query, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=xxx"

    static class Query {
        String component_access_token
    }

    static class Req {

        /**
         * 第三方平台方appid
         */
        String component_appid

        /**
         * 授权方appid
         */
        String authorizer_appid

        /**
         * 授权方的刷新令牌
         * 刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
         * 只会在授权时刻提供，请妥善保存。一旦丢失，
         * 只能让用户重新授权，才能再次拿到新的刷新令牌
         */
        String authorizer_refresh_token
    }

    static class Resp {

        /**
         * 授权方令牌
         */
        String authorizer_access_token

        /**
         * 有效期，为2小时
         */
        int expires_in

        /**
         * 刷新令牌
         */
        String authorizer_refresh_token

    }
}
