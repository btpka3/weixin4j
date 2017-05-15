package com.github.btpka3.weixin4j.mp.push.msg.event

import com.github.btpka3.weixin4j.mp.push.msg.EventMsg

/**
 *
 */
class SubscribeEvent extends EventMsg {

    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    String EventKey

    /**
     * 二维码的ticket
     */
    String Ticket
}
