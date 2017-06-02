package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class LinkMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "link"
    Long MsgId

    /**
     * 消息标题
     */
    String Title

    /**
     * 消息描述
     */
    String Description

    /**
     * 消息链接
     */
    String Url

}
