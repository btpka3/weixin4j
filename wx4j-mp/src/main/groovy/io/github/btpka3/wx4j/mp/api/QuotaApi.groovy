package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 限制清除相关 Api
 */
@CompileStatic
interface QuotaApi extends WxMpApi {

    String API_URI_clear = "https://api.weixin.qq.com/cgi-bin/clear_quota"


    ClearResp clear(
            String access_token,
            String secret
    )

    static class ClearReq extends BaseReq {
        String appid
    }

    static class ClearResp extends BaseResp {


    }

}
