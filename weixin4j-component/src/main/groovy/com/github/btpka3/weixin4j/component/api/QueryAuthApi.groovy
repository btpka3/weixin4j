package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获取预授权码pre_auth_code
 */
@CompileStatic
interface QueryAuthApi {


    Resp createPreAuthCode(Req)

    static class Req {

        /** 第三方平台方appid */
        String component_appid

        /** 授权code,会在授权成功时返回给第三方平台 */
        String authorization_code

    }

    static class Resp {

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
            int expires_in

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
