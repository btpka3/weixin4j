package io.github.btpka3.wx4j.qy.api

import io.github.btpka3.wx4j.qy.WxQyApi
import io.github.btpka3.wx4j.qy.WxQyApi.BaseResp

/**
 *
 */
interface AppAtApi extends WxQyApi {

    String API_URI_getAppAt = "https://qyapi.weixin.qq.com/cgi-bin/gettoken"

    GetTicketResp getAppAt(
            String corpid,
            String corpsecret
    )

    static class GetTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
