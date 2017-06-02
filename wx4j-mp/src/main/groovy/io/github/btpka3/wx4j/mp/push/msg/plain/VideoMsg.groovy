package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class VideoMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "video"
    Long MsgId

    /**
     * 图片消息媒体id
     */
    long MediaId

    /**
     * 视频消息缩略图的媒体id
     */
    String ThumbMediaId


}
