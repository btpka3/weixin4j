package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 扫码推事件的事件推送
 */
class ScanCodePushEvent extends EventMsg {


   final String Event = "scancode_push"

    /**
     * 事件KEY值，由开发者在创建菜单时设定
     */
    String EventKey

    ScanCodeInfo ScanCodeInfo

    String ScanResult

    public static class ScanCodeInfo {

        /**
         * 扫描类型，一般是qrcode
         */
        String ScanType

        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        String ScanResult
    }
}
