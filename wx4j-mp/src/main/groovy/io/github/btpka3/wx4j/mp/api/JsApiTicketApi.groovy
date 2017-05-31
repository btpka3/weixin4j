package io.github.btpka3.wx4j.mp.api

import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 *
 */
interface JsApiTicketApi extends WxMpApi {

    String API_URI_getTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket"

    GetTicketResp getTicket(String access_token)

    static class GetTicketResp extends BaseResp {
        String ticket
        int expires_in
    }
}
