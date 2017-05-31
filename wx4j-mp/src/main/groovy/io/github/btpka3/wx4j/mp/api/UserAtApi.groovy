package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 获取 用户授权的 access_token
 */
@CompileStatic
interface UserAtApi extends WxMpApi {

    static final String API_URL_createAuthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize"

    static final String API_URI_isValid = "https://api.weixin.qq.com/sns/auth"

    static final String API_URI_getUserAt = "https://api.weixin.qq.com/sns/oauth2/access_token"

    static final String API_URI_refresh = "https://api.weixin.qq.com/sns/oauth2/refresh_token"

    /**
     *
     * @param appid
     * @param redirect_uri
     * @param scope 应用授权作用域。
     *      snsapi_base  - 不弹出授权页面，直接跳转，只能获取用户openid
     *      snsapi_userinfo - 会弹出授权页面，可通过openid拿到昵称、性别、所在地。无需用户关注微信公众号
     *
     * @param state 最多128字节
     * @return
     */
    String createUserAuthUrl(
            String appid,
            String redirect_uri,
//            String response_type,
            String scope,
            String state
    )

    IsValidResp isValid(
            String access_token,
            String openid
    )

    RefreshResp refresh(
            String appid,
//            String grant_type,
            String refresh_token
    )

    /**
     * 通过 code 换取用户级别的 access token。
     *
     * @param appid
     * @param secret
     * @param code
     * @param grant_type
     * @return
     */
    // grant_type = "authorization_code"
    GetUserAtResp getUserAt(
            String appid,
            String secret,
            String code//,
//            String grant_type
    )


    static class RefreshResp extends BaseResp {
        /**
         * 网页授权接口调用凭证
         */
        String access_token

        /**
         * access_token接口调用凭证超时时间，单位（秒）
         */
        int expires_in

        /**
         * 用户刷新access_token
         */
        String refresh_token

        /**
         * 用户唯一标识
         */
        String openid

        /**
         * 用户授权的作用域，使用逗号（,）分隔
         */
        String scope
    }

    static class IsValidResp extends BaseResp {
    }


    static class GetUserAtResp extends BaseResp {
        String access_token
        Integer expires_in
        String refresh_token
        String openid
        String scope
    }

    static class Resp {

        String access_token

    }
}
