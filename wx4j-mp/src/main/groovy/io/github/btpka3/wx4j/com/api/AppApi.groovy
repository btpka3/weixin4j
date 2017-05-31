package io.github.btpka3.wx4j.com.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.com.WxComApi
import io.github.btpka3.wx4j.com.WxComApi.BaseReq
import io.github.btpka3.wx4j.com.WxComApi.BaseResp

/**
 *
 */
@CompileStatic
interface AppApi extends WxComApi {

    String API_URI_info = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info"
    String API_URI_getOption = "https://api.weixin.qq.com/cgi-bin/component/ api_get_authorizer_option"
    String API_URI_setOption = "https://api.weixin.qq.com/cgi-bin/component/ api_set_authorizer_option"

    /** 获取授权方的帐号基本信息 */
    InfoResp info(
            String component_access_token,
            InfoReq infoReq
    )

    /** 获取授权方的选项设置信息 */
    GetOptionResp getOption(
            String component_access_token,
            GetOptionReq getOptionReq
    )

    /** 获取授权方的选项设置信息 */
    SetOptionResp setOption(
            String component_access_token,
            SetOptionReq setOptionReq
    )


    static class SetOptionReq extends BaseReq {

        /** 第三方平台appid */
        String component_appid

        /** 授权公众号或小程序的appid */
        String authorizer_appid

        /**
         * 选项名称
         *
         * location_report (地理位置上报选项)
         *      0 - 无上报
         *      1 - 进入会话时上报
         *      2 - 每5s上报
         *
         * voice_recognize （语音识别开关选项）
         *      0 - 关闭语音识别
         *      1 - 开启语音识别
         *
         * customer_service （多客服开关选项）
         *      0 - 关闭多客服
         *      1 - 开启多客服
         */
        String option_value

        /** 设置的选项值 */
        String option_name
    }

    static class SetOptionResp extends BaseResp {

    }

    static class GetOptionReq extends BaseReq {

        /** 第三方平台appid */
        String component_appid

        /** 授权公众号或小程序的appid */
        String authorizer_appid

        /** 选项名称 */
        String option_name
    }

    static class GetOptionResp extends BaseResp {
        String authorizer_appid
        String option_name
        String option_value
    }


    static class InfoReq extends BaseReq {

        /**
         * 服务appid
         */
        String component_appid

        /**
         * 授权方appid
         */
        String authorizer_appid


    }

    static class InfoResp extends BaseResp {
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

            /**
             * 授权方公众号所设置的微信号，可能为空
             */
            String alias

            /**
             * 二维码图片的URL，开发者最好自行也进行保存
             */
            String qrcode_url

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
