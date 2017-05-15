package com.github.btpka3.weixin4j.mp.api.auth

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 获取 access_token
 */
@CompileStatic
interface AppAtApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/token"

    static class Query {
        String grant_type
        String appid
        String secret
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

        /**
         * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
         */
        String unionid
    }
}
