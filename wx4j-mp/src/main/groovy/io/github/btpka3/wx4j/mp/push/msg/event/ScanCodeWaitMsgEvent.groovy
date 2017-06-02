package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 扫码推事件且弹出“消息接收中”提示框的事件推送
 */
class ScanCodeWaitMsgEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "scancode_waitmsg"

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
