package io.github.btpka3.wx4j.mp.api.qrcode

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 创建二维码ticket
 */
@CompileStatic
interface CreateQRcodeApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/qrcode/create"

    static class Query {
        String access_token
    }

    static abstract class Req {

        /**
         * 二维码类型
         *
         * QR_SCENE - 临时
         * QR_LIMIT_SCENE  - 永久
         * QR_LIMIT_STR_SCENE - 永久的字符串参数值
         */
        String action_name

        /**
         * 二维码详细信息
         */
        String action_info

        static class ActionInfo {
            Scene scene

            static class Scene {

                /**
                 * 场景值ID。
                 * 临时二维码时为32位非0整型，
                 * 永久二维码时最大值为100000（目前参数只支持1--100000）
                 */
                long scene_id
            }
        }
    }

    static class TmpSceneReq extends Req {
        /**
         * 该二维码有效时间，以秒为单位
         *
         * 最长可以设置为在二维码生成后的7天（即604800秒）后过期
         */
        int expire_seconds
    }

    static class PersistSceneReq extends Req {

    }
}
