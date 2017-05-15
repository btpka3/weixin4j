package com.github.btpka3.weixin4j.mp.push.msg.plain

import com.github.btpka3.weixin4j.mp.push.msg.PlainMsg

/**
 *
 */
class ShortVideoMsg extends PlainMsg {

    /**
     * 图片消息媒体id
     *
     * 只有当  MsgType in ("image","voice","video") 时才有值
     */
    long MediaId

    /**
     * 视频消息缩略图的媒体id
     *
     * 只有当  MsgType in ("video", "shortvideo") 时才有值
     */
    String ThumbMediaId

}
