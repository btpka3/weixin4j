package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获取预授权码pre_auth_code
 */
@CompileStatic
@Deprecated
// AppAtApi#getAppAt
interface QueryAuthApi {


    Resp createPreAuthCode(Req)

    static class Req {

        /** 第三方平台方appid */
        String component_appid

        /** 授权code,会在授权成功时返回给第三方平台 */
        String authorization_code

    }

    static class Resp {

    }
}
