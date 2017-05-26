package io.github.btpka3.wx4j.mp.push.reply

import io.github.btpka3.wx4j.mp.push.ReplyMsg

/**
 * 回复音乐消息
 */
class MusicReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    final String MsgType = "music"

    /**
     * 音乐标题
     */
    String Title

    /**
     * 音乐描述
     */
    String Description

    /**
     * 音乐链接
     */
    String MusicURL

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    String HQMusicUrl

    /**
     * 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
     */
    String ThumbMediaId

}
