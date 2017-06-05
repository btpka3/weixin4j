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

    String API_URI_createTicket = "https://api.weixin.qq.com/cgi-bin/qrcode/create"
    String API_URI_getImgByTicket = "https://mp.weixin.qq.com/cgi-bin/showqrcode"

    // ----------------------------------------------

    /**
     * 创建二维码ticket
     */
    CreateTicketResp createTicket(
            String access_token,
            CreateTicketReq createTicketReq
    )


    static abstract class CreateTicketReq extends BaseReq {

    }

    static class TmpReq extends CreateTicketReq {

        /**
         * 二维码类型
         *
         * QR_SCENE - 临时
         * QR_LIMIT_SCENE  - 永久
         * QR_LIMIT_STR_SCENE - 永久的字符串参数值
         */
        final String action_name = "QR_SCENE"

        /**
         * 该二维码有效时间，以秒为单位
         *
         * 最长可以设置为在二维码生成后的7天（即604800秒）后过期
         */
        Integer expire_seconds

        /**
         * 二维码详细信息
         */
        ActionInfo action_info

        static class ActionInfo {
            Scene scene

            static class Scene {

                /**
                 * 场景值ID。
                 * 临时二维码时为32位非0整型，
                 * 永久二维码时最大值为100000（目前参数只支持1--100000）
                 */
                Integer scene_id
            }
        }
    }

    static class PersistReq extends CreateTicketReq {

        /**
         * 二维码类型
         *
         * QR_SCENE - 临时
         * QR_LIMIT_SCENE  - 永久
         * QR_LIMIT_STR_SCENE - 永久的字符串参数值
         */
        final String action_name = "QR_LIMIT_SCENE"

        /**
         * 二维码详细信息
         */
        ActionInfo action_info

        static class ActionInfo {
            Scene scene

            static class Scene {

                /**
                 * 场景值ID。
                 * 临时二维码时为32位非0整型，
                 * 永久二维码时最大值为100000（目前参数只支持1--100000）
                 */
                Integer scene_id
            }
        }
    }

    static class PersistStrReq extends CreateTicketReq {

        /**
         * 二维码类型
         *
         * QR_SCENE - 临时
         * QR_LIMIT_SCENE  - 永久
         * QR_LIMIT_STR_SCENE - 永久的字符串参数值
         */
        final String action_name = "QR_LIMIT_STR_SCENE"

        /**
         * 二维码详细信息
         */
        ActionInfo action_info

        static class ActionInfo {
            Scene scene

            static class Scene {

                /**
                 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
                 */
                String scene_str
            }
        }
    }

    static class CreateTicketResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 通过ticket换取二维码
     */
    byte[] getImgByTicket(
            String ticket
    )


}
