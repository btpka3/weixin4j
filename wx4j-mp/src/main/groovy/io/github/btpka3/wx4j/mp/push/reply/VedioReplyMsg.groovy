package io.github.btpka3.wx4j.mp.push.reply

import io.github.btpka3.wx4j.mp.push.ReplyMsg

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
