package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获获取（刷新）授权公众号或小程序的接口调用凭据（令牌） - 微信公众号
 */
@CompileStatic
interface GetAuthorizerInfo4WxPubNoApi extends WxComApi<Query, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info"

    static class Query{
        String component_access_token
    }

    static class Req {

        /** 第三方平台方appid */
        String component_appid

        /** 授权方appid */
        String authorizer_appid

    }

    static class Resp {




    }
}
