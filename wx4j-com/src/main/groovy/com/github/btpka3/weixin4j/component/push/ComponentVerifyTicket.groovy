package com.github.btpka3.weixin4j.component.push

/**
 * 推送的 component_verify_ticket
 */
class ComponentVerifyTicket {

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
     * Ticket内容
     */
    String ComponentVerifyTicket

}
