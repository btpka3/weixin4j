package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 获取 access_token
 */
@CompileStatic
interface AppAtApi extends WxMpApi {

    String API_URI_getAppAt = "https://api.weixin.qq.com/cgi-bin/token"


    // ----------------------------------------------
    GetAppAtResp getAppAt(
            String appid,
            String secret
    )

    static class GetAppAtResp extends BaseResp {

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
