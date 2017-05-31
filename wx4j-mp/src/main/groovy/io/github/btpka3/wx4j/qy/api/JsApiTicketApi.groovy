package io.github.btpka3.wx4j.qy.api

import io.github.btpka3.wx4j.qy.WxQyApi.BaseResp
import io.github.btpka3.wx4j.qy.WxQyApi

/**
 *
 */
interface JsApiTicketApi extends WxQyApi {

    String API_URI_getTicket = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket"

    GetTicketResp getTicket(String access_token)

    static class GetTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
