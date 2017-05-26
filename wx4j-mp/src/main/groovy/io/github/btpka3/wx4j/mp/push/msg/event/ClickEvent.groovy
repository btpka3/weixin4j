package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 点击菜单跳转链接时的事件推送
 */
class ClickEvent extends EventMsg {

    /**
     * 事件KEY值，设置的跳转URL
     */
    String EventKey

}
