package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 点击菜单拉取消息时的事件推送
 */
class ClickEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "CLICK"

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    String EventKey

}
