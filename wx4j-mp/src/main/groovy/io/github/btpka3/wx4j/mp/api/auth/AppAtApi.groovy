package io.github.btpka3.wx4j.mp.api.auth

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.core.WxApi
import io.github.btpka3.wx4j.mp.api.auth.model.GetAppAtResp

/**
 * 获取 access_token
 */
@CompileStatic
interface AppAtApi extends WxApi {

    String API_URI_getAppAt = "https://api.weixin.qq.com/cgi-bin/token"



    GetAppAtResp getAppAt(
            String grant_type,
            String appid,
            String secret
    )


}
