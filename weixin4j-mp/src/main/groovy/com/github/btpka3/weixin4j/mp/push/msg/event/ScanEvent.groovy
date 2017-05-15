package com.github.btpka3.weixin4j.mp.push.msg.event

import com.github.btpka3.weixin4j.mp.push.msg.EventMsg

/**
 * 用户已关注时的事件推送
 */
class ScanEvent extends EventMsg {

    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    String EventKey

    /**
     * 二维码的ticket
     */
    String Ticket

}
