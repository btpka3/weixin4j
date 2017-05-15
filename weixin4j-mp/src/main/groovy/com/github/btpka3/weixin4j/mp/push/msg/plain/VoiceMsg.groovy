package com.github.btpka3.weixin4j.mp.push.msg.plain

import com.github.btpka3.weixin4j.mp.push.msg.PlainMsg

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
