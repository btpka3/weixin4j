package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 *
 */
class LocationSelectEvent extends EventMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "location_select"

    /**
     * 地理位置纬度
     */
    String Latitude

    /**
     * 地理位置经度
     */
    String Longitude

    /**
     * 地理位置精度
     */
    String Precision

    /**
     * 发送的位置信息
     */
    public static class SendLocationInfo {

        /**
         * X坐标信息
         */
        String Location_X

        /**
         * Y坐标信息
         */
        String Location_Y

        /**
         * 精度，可理解为精度或者比例尺、越精细的话 scale越高
         */
        String Scale

        /**
         * 地理位置的字符串信息
         */
        String Label

        /**
         * 朋友圈POI的名字，可能为空
         */
        String Poiname
    }
}
