package io.github.btpka3.wx4j.mp.push.msg

import io.github.btpka3.wx4j.mp.push.WxMpMsg

/**
 *
 */
class EventMsg implements WxMpMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    String MsgType
    String Event
}
