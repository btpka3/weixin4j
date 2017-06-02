package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 用户已关注时的事件推送
 */
class ScanEvent extends EventMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "SCAN"

    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    String EventKey

    /**
     * 二维码的ticket
     */
    String Ticket

}
