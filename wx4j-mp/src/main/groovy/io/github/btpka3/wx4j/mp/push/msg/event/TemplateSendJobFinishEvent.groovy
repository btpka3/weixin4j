package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知
 */
class TemplateSendJobFinishEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "TEMPLATESENDJOBFINISH"

    /**
     * 消息id
     */
    Long MsgID

    /**
     * 发送状态
     */
    String Status

}
