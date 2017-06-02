package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class ImageMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "image"
    Long MsgId

    /**
     * 图片链接
     */
    String PicUrl

    /**
     * 图片消息媒体id
     */
    String MediaId
}
