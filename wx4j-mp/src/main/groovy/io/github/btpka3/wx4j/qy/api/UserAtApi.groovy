package io.github.btpka3.wx4j.qy.api

import io.github.btpka3.wx4j.qy.WxQyApi
import io.github.btpka3.wx4j.qy.WxQyApi.BaseResp

/**
 *
 */
interface UserAtApi extends WxQyApi {

    String API_URI_createAuthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize"

    String API_URI_getUserAt = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo"


    String createAuthUrl(
            String appid,
            String redirect_uri,
            String response_type,
            String scope,
            String agentid,
            String state
    )

    GetUserAtResp getUserAt(
            String access_token,
            String code
    )

    static class GetUserAtResp extends BaseResp {

        // 非企业成员授权时返回
        String OpenId

        // 企业成员授权时返回
        String UserId
        String DeviceId
        String user_ticket
        Integer expires_in
    }

}
