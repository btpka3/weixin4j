package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获取第三方平台component_access_token
 */
@CompileStatic
@Deprecated
interface ComponentTokenApi extends WxComApi<Void, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/component/api_component_token"

    static class Req {

        /** 第三方平台方appid */
        String component_appsecret

        /** 第三方平台appsecret */
        String component_verify_ticket

        /** 微信后台推送的ticket，此ticket会定时推送 */
        String component_appid
    }

    static class Resp {

        /** 第三方平台access_token */
        String component_access_token

        /** 有效期 */
        int expires_in
    }
}
