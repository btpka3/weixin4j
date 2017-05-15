package com.github.btpka3.weixin4j.mp.push.msg.event

import com.github.btpka3.weixin4j.mp.push.msg.EventMsg

/**
 *
 */
class LocationEvent extends EventMsg {

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
}
