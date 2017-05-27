package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 创建二维码ticket
 */
@CompileStatic
interface QRcodeApi extends WxMpApi {

    String API_URI_create = "https://api.weixin.qq.com/cgi-bin/qrcode/create"
    String API_URI_getImg = "https://mp.weixin.qq.com/cgi-bin/showqrcode"

    CreateResp create(String access_token, CreateReq createReq)

    byte[] getImg(String ticket)


    static abstract class CreateReq extends BaseReq {

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

    static class TmpSceneReq extends CreateReq {
        /**
         * 该二维码有效时间，以秒为单位
         *
         * 最长可以设置为在二维码生成后的7天（即604800秒）后过期
         */
        int expire_seconds
    }

    static class CreateResp extends BaseResp {

    }

    static class PersistSceneReq extends CreateReq {

    }


}
