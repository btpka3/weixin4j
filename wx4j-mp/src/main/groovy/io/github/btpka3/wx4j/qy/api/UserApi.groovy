package io.github.btpka3.wx4j.qy.api

import io.github.btpka3.wx4j.qy.WxQyApi
import io.github.btpka3.wx4j.qy.WxQyApi.BaseReq
import io.github.btpka3.wx4j.qy.WxQyApi.BaseResp

/**
 *
 */
interface UserApi extends WxQyApi {

    String API_URI_info = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail"
    String API_URI_userIdToOpenId = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid"
    String API_URI_openIdToUserId = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid"

    String info(
            String access_token,
            String code
    )

    UserIdToOpenIdResp userIdToOpenId(
            String access_token,
            UserIdToOpenIdReq userIdToOpenIdReq
    )

    void openIdToUserId(
            String access_token,
            OpenIdToUserIdReq openIdToUserIdReq
    )

    static class OpenIdToUserIdReq extends BaseReq {
        String openid
    }

    static class OpenIdToUserIdResp extends BaseResp {
        String userid
    }

    static class UserIdToOpenIdReq extends BaseReq {
        String userid

        /**
         * 整型，需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数
         */
        String agentid
    }

    static class UserIdToOpenIdResp extends BaseResp {
        String openid
        String appid
    }

    static class InfoReq extends BaseReq {
        String user_ticket
    }

    static class InfoResp extends BaseResp {

        String userid

        String name

        /**
         * 性别。
         *
         * 0 - 未定义
         * 1 - 男性
         * 2 - 女性
         */
        String gender

        List<Integer> department

        /**
         * 职位信息
         */
        String position

        /**
         * 头像url.
         *
         * 注意：如果要获取小图将url最后的”/0”改成”/64”即可。
         */
        String avatar

        /**
         * 成员手机号，仅在用户同意snsapi_privateinfo授权时返回
         */
        String mobile

        /**
         * 成员邮箱，仅在用户同意snsapi_privateinfo授权时返回
         */
        String email
    }
}
