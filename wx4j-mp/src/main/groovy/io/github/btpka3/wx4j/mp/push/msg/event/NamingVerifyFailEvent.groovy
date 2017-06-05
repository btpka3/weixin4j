package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
 */
class NamingVerifyFailEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "naming_verify_fail"

    /**
     * 失败发生时间 (整形)，时间戳
     */
    Long FailTime

    /**
     * 认证失败的原因
     */
    String FailReason

}
