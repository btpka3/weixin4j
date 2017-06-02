package io.github.btpka3.wx4j.mp.push.msg.event

import io.github.btpka3.wx4j.mp.push.msg.EventMsg

/**
 * 弹出系统拍照发图的事件推送
 */
class PicSysPhotoMsgEvent extends EventMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "pic_sysphoto"

    /**
     * 事件KEY值，由开发者在创建菜单时设定
     */
    String EventKey

    SendPicsInfo SendPicsInfo

    String ScanResult

    public static class SendPicsInfo {

        /**
         * 扫描类型，一般是qrcode
         */
        Integer Count

        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        List<Item> PicList

        public static class Item {
            String PicMd5Sum
        }
    }
}
