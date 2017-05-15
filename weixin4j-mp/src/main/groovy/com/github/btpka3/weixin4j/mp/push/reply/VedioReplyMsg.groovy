package com.github.btpka3.weixin4j.mp.push.reply

import com.github.btpka3.weixin4j.mp.push.ReplyMsg

/**
 * 回复视频消息
 */
class VedioReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    final String MsgType = "vedio"

    /**
     * 通过素材管理接口上传多媒体文件，得到的id
     */
    String MediaId

    /**
     * 视频消息的标题
     */
    String Title

    /**
     * 视频消息的描述
     */
    String Description
}
