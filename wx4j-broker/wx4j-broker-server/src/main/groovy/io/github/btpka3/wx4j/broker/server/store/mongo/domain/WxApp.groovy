package io.github.btpka3.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed

/**
 *
 */
class WxApp extends Base {

    /**
     * 微信号的类型。
     */
    WxAppTypeEnum wxAppType

    /**
     * 是否被管理。
     * <p>
     * true - 则会自动刷新 accessToken
     */
    boolean managed;

    /**
     * 注册时使用的Email。
     */
    String regEmail;

    /**
     * APP ID/CorpID。
     *
     * 比如："wxbba6def439fc0bd0"
     */
    @Indexed(unique = true)
    String appId;

    /**
     * App Secret/providerSecret
     */
    String appSecret

    /**
     * 微信号.
     *
     * 比如："qhkingsilk"
     */
    String wxNo

    /**
     * 中文名称/平台名称。
     *
     * 比如："小皇叔"
     */
    String name

    /**
     * 授权后代替公众号实现业务 - 公众号消息校验Token
     */
    String msgVerifyToken;

    /**
     * 授权后代替公众号实现业务 - 公众号消息加解密Key
     */
    String msgEncKey;

    /**
     * 只有当 type = WxAppTypeEnum.COM 时，该字段才有值。
     */
    Set<AuthedWxApp> authedWxApps;

    /**
     * 二维码图片地址。
     * <p>
     * 类型：二维码边长：8cm，建议扫描距离 0.5m。
     */
    String qrCodeImgUrl;

    /**
     * 备注
     */
    String memo;

    // TODO 该类需要重新设计，有可能与 WxApp 合并。
    static class AuthedWxApp {

        /**
         * 授权的APP信息。
         */
//        WxApp wxApp;
        String appId;

        /**
         * 公众号授权码
         */
        String authCode;

        /**
         * 公众号授权码的过期时间
         */
        Date authCodeExpiredAt;


        AuthorizerInfo authorizerInfo;

//
//        /**
//         * 最后一次操作的类型
//         * unauthorized;授权成功
//         * authorized;授权更新
//         * updateauthorized;授权更新
//         */
//        String infoType;

        // TODO 按照 “6、获取授权方的公众号帐号基本信息" 完善。
        static class AuthorizerInfo {

            /**
             * 授权方昵称
             */
            String nickName;

            /**
             * 授权方头像的网址
             */
            String headImg;

            /**
             * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
             */
            Integer serviceTypeInfo;

            /**
             * 授权方认证类型，
             * -1代表未认证，
             * 0代表微信认证，
             * 1代表新浪微博认证，
             * 2代表腾讯微博认证，
             * 3代表已资质认证通过但还未通过名称认证，
             * 4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
             * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
             */
            String verifyTypeInfo;

            /**
             * 授权方公众号的原始ID
             */
            String userName;

            /**
             * 公众号的主体名称
             */
            String principalName;

            /**
             * 授权方公众号所设置的微信号，可能为空
             */
            String alias;

            /**
             * 用以了解以下功能的开通状况（0代表未开通，1代表已开通）：
             * open_store:是否开通微信门店功能
             * open_scan:是否开通微信扫商品功能
             * open_pay:是否开通微信支付功能
             * open_card:是否开通微信卡券功能
             * open_shake:是否开通微信摇一摇功能
             */
            String businessInfo;

            /**
             * 二维码图片的URL，开发者最好自行也进行保存
             */
            String qrcodeUrl;

            /**
             * 存的是id的值
             * 公众号授权给开发者的权限集列表
             * ID为1到15时分别代表：
             * 1. 消息管理权限
             * 2. 用户管理权限
             * 3. 帐号服务权限
             * 4. 网页服务权限
             * 5. 微信小店权限
             * 6. 微信多客服权限
             * 7. 群发与通知权限
             * 8. 微信卡券权限
             * 9. 微信扫一扫权限
             * 10. 微信连WIFI权限
             * 11. 素材管理权限
             * 12. 微信摇周边权限
             * 13. 微信门店权限
             * 14. 微信支付权限
             * 15. 自定义菜单权限
             */
            Set<String> funcInfo = new LinkedHashSet<>();


        }

    }

    // ------------------------ 自动生成的 getter、 setter


}
