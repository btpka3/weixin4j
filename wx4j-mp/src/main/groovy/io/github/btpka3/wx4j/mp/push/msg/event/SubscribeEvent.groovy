package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 关注事件.
 *
 *
 */
class SubscribeEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "subscribe"


    /**
     * 事件KEY值。
     *
     * 当 扫描带参数二维码事件，该字段才有值。
     * qrscene_为前缀，后面为二维码的参数值
     */
    String EventKey

    /**
     * 当 扫描带参数二维码事件，该字段才有值。
     * 二维码的ticket
     */
    String Ticket
}
