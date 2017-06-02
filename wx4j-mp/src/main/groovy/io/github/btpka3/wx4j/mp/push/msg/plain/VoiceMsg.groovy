package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class VoiceMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "voice"
    Long MsgId

    /**
     * 图片消息媒体id
     *
     */
    String MediaId

    /**
     * 语音格式，如amr，speex等
     */
    String Format

    /**
     * 语音识别结果.
     *
     * 需公众号开通语音识别。
     */
    String Recognition

}
