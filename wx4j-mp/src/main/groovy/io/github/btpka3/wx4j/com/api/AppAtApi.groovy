package io.github.btpka3.wx4j.com.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.com.WxComApi
import io.github.btpka3.wx4j.com.WxComApi.BaseReq
import io.github.btpka3.wx4j.com.WxComApi.BaseResp

/**
 *
 */
@CompileStatic
interface AppAtApi extends WxComApi {

    String API_URI_preAuth = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode"
    String API_URI_createAppAuthUrl = "https://mp.weixin.qq.com/cgi-bin/componentloginpage"
    String API_URI_getAppAt = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth"

    /** 获取预授权码 */
    PreAuthResp preAuth(
            String component_access_token,
            PreAuthReq preAuthReq
    )


    String createAppAuthUrl(
            String component_appid,
            String pre_auth_code,
            String redirect_uri
    )


    GetAppAtResp getAppAt(
            String component_access_token,
            GetAppAtReq getAppAtReq
    )

    static class PreAuthReq extends BaseReq {

        /**
         * 第三方平台方appid
         */
        String component_appid

    }

    static class PreAuthResp extends BaseResp {

        /** 预授权码 */
        String pre_auth_code

        /** 有效期，为20分钟 */
        Integer expires_in
    }


    static class GetAppAtReq extends BaseReq {
        String component_appid
        String authorization_code

    }

    static class GetAppAtResp extends BaseResp {

        /** 授权信息 */
        AuthorizationInfo authorization_info

        static class AuthorizationInfo {

            /** 授权方appid */
            String authorizer_appid

            /**
             * 授权方接口调用凭据（在授权的公众号或小程序具备API权限时，才有此返回值），也简称为令牌
             */
            String authorizer_access_token

            /** 有效期（在授权的公众号或小程序具备API权限时，才有此返回值） */
            Integer expires_in

            /**
             * 接口调用凭据刷新令牌。
             * （在授权的公众号具备API权限时，才有此返回值），
             * 刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
             * 只会在授权时刻提供，请妥善保存。
             * 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
             */
            String authorizer_refresh_token

            /**
             * 公众号授权给开发者的权限集列表.
             *
             * <pre>
             * 1 - 消息管理权限
             * 2 - 用户管理权限
             * 3 - 帐号服务权限
             * 4 - 网页服务权限
             * 5 - 微信小店权限
             * 6 - 微信多客服权限
             * 7 - 群发与通知权限
             * 8 - 微信卡券权限
             * 9 - 微信扫一扫权限
             * 10 - 微信连WIFI权限
             * 11 - 素材管理权限
             * 12 - 微信摇周边权限
             * 13 - 微信门店权限
             * 14 - 微信支付权限
             * 15 - 自定义菜单权限
             * </pre>
             */
            List<FuncInfo> func_info

            static class FuncInfo {
                FuncScopeCategory funcscope_category

                static class FuncScopeCategory {
                    long id
                }
            }
        }
    }

}
