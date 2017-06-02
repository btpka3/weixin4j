package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class LocationMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "location"
    Long MsgId


    /**
     * 地理位置维度
     */
    String Location_X

    /**
     * 地理位置经度
     */
    String Location_Y

    /**
     * 地图缩放大小
     */
    String Scale

    /**
     * 地理位置信息
     */
    String Label


}
