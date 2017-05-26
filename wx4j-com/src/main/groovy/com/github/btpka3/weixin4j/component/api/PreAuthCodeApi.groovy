package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获取预授权码pre_auth_code
 */
@CompileStatic
interface PreAuthCodeApi {


    Resp createPreAuthCode(Req)

    static class Req {
        /** 第三方平台方appid */
        String component_appid
    }

    static class Resp {

        /** 预授权码 */
        String pre_auth_code

        /** 有效期，为20分钟 */
        int expires_in
    }
}
