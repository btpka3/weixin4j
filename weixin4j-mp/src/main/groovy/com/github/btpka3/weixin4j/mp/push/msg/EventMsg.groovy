package com.github.btpka3.weixin4j.mp.push.msg

import com.github.btpka3.weixin4j.mp.push.WxMpMsg

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
