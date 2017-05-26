package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class VoiceMsg extends PlainMsg {

    /**
     * 图片消息媒体id
     *
     */
    long MediaId

    /**
     * 语音格式，如amr，speex等
     */
    String Format

}
