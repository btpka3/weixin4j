package com.github.btpka3.weixin4j.component.push

/**
 * Created by zll on 10/05/2017.
 */
class AuthEventNotify {

    /**
     * 第三方平台appid
     */
    String AppId

    /**
     *
     */
    String CreateTime

    /**
     * 通知类型：
     *
     * <pre>
     * unauthorized - 取消授权
     * authorized - 授权成功
     * updateauthorized - 授权更新
     * </pre>
     */
    String InfoType

    /**
     * 公众号或小程序 的 appId
     */
    String AuthorizerAppid

    /**
     * 授权码，可用于换取公众号的接口调用凭据。
     *
     * 只有当 InfoType 为 "authorized"，"updateauthorized" 时才有值
     */
    String AuthorizationCode

    /**
     * 授权码过期时间
     *
     * 只有当 InfoType 为 "authorized"，"updateauthorized" 时才有值
     */
    String AuthorizationCodeExpiredTime
}
