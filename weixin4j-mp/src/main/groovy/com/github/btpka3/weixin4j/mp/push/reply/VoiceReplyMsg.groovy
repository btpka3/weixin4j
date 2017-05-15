package com.github.btpka3.weixin4j.mp.push.reply

import com.github.btpka3.weixin4j.mp.push.ReplyMsg

/**
 *
 */
class VoiceReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    final String MsgType = "voice"

    /**
     * 通过素材管理接口上传多媒体文件，得到的id
     */
    String MediaId
}