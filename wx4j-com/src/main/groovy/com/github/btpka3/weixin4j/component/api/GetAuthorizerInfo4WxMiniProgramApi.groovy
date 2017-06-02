package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic

/**
 * 获获取（刷新）授权公众号或小程序的接口调用凭据（令牌） - 小程序
 */
@CompileStatic
@Deprecated // AppApi#getOption
interface GetAuthorizerInfo4WxMiniProgramApi extends WxComApi<Query, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info"

    static class Query {
        String component_access_token
    }

    static class Req {

        /** 第三方平台方appid */
        String component_appid

        /** 授权方appid */
        String authorizer_appid

    }

    static class Resp {

        AuthorizerInfo authorizer_info

        AuthorizationInfo authorization_info


        static class AuthorizerInfo {

            /**
             * 授权方昵称
             */
            String nick_name

            /**
             * 授权方头像
             */
            String head_img


            ServiceTypeInfo service_type_info

            VerifyTypeInfo verify_type_info

            /**
             * 授权方公众号的原始ID
             */
            String user_name

            /**
             * 公众号的主体名称
             */
            String principal_name


            BusinessInfo business_info

//            /**
//             * 授权方公众号所设置的微信号，可能为空
//             */
//            String alias

            /**
             * 二维码图片的URL，开发者最好自行也进行保存
             */
            String qrcode_url

            /**
             * 帐号介绍
             */
            String signature

            MiniProgramInfo miniprograminfo

            /**
             * 授权方公众号类型
             * <pre>
             *  0 - 代表订阅号
             *  1 - 代表由历史老帐号升级后的订阅号
             *  2 - 代表服务号
             * </pre>
             */
            static class ServiceTypeInfo {
                long id
            }

            /**
             * 授权方认证类型。
             *
             * <pre>
             *  -1 - 代表未认证
             *  0 - 代表微信认证
             *  1 - 代表新浪微博认证
             *  2 - 代表腾讯微博认证
             *  3 - 代表已资质认证通过但还未通过名称认证
             *  4 - 代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
             *  5 - 代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
             * </pre>
             */
            static class VerifyTypeInfo {
                long id
            }

            /**
             * 用以了解以下功能的开通状况（0代表未开通，1代表已开通）：
             * <pre>
             * open_store   :是否开通微信门店功能
             * open_scan    :是否开通微信扫商品功能
             * open_pay     :是否开通微信支付功能
             * open_card    :是否开通微信卡券功能
             * open_shake   :是否开通微信摇一摇功能
             * </pre>
             */
            static class BusinessInfo {

                long open_store
                long open_scan
                long open_pay
                long open_card
                long open_shake
            }

            static class MiniProgramInfo {

                Network network

                List<Category> categories

                long visit_status

                /**
                 * 小程序已设置的各个服务器域名
                 */
                static class Network {
                    List<String> requestdomain
                    List<String> wsrequestdomain
                    List<String> uploaddomain
                    List<String> downloaddomain
                }

                static class Category{
                    String first
                    String second
                }

            }
        }

        /**
         * 授权信息
         */
        static class AuthorizationInfo {

            /**
             * 授权方appid
             */
            String appid

            /**
             * 公众号授权给开发者的权限集列表.
             */
            List<FuncInfo> func_info

            /**
             * 公众号授权给开发者的权限.
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
             *
             * 17 - 帐号管理权限
             * 18 - 开发管理权限
             * 19 - 客服消息管理权限
             * </pre>
             */
            static class FuncInfo {

                static class FuncScopeCategory {
                    long id
                }
            }
        }


    }
}
