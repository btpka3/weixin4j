package io.github.btpka3.wx4j.mp.api.auth

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 检验授权凭证（access_token）是否有效
 */
@CompileStatic
interface CheckUserAtApi extends WxMpApi<Query, Void, Void> {

    String API_URI = "https://api.weixin.qq.com/sns/auth"

    static class Query {

        /**
         * 网页授权接口调用凭证
         */
        String access_token

        /**
         * 用户的唯一标识
         */
        String openid
    }
}
