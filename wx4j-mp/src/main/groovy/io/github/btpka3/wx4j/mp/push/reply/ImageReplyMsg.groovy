package io.github.btpka3.wx4j.mp.push.reply

import io.github.btpka3.wx4j.mp.push.ReplyMsg

/**
 *
 */
class ImageReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "image"
    String MsgId

    static class Image {

        /**
         * 通过素材管理接口上传多媒体文件，得到的id
         */
        String MediaId
    }
}
