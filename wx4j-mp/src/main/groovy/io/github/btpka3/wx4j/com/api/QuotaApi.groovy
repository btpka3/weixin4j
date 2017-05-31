package io.github.btpka3.wx4j.com.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.com.WxComApi

/**
 * 限制清除相关 Api
 */
@CompileStatic
interface QuotaApi extends WxComApi {

    String API_URI_clear = "https://api.weixin.qq.com/cgi-bin/component/clear_quota"

    /** 清零 第三方平台 的 quota */
    ClearResp clear(String component_access_token, ClearResp clearReq)

    static class ClearReq extends WxComApi.BaseReq {
        String component_appid
    }

    static class ClearResp extends WxComApi.BaseResp {

    }

}
