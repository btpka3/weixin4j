package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 长链接转短链接接口
 */
@CompileStatic
interface ShortUrlApi extends WxMpApi {

    String API_URI_shorten = "https://api.weixin.qq.com/cgi-bin/shorturl"

    /**
     * 将一条长链接转成短链接
     */
    ShortenResp shorten(
            String access_token,
            ShortenReq shortenReq
    )

    static class ShortenReq extends BaseReq {
        String action
        String long_url
    }

    static class ShortenResp extends BaseResp {
        String short_url
    }
}
