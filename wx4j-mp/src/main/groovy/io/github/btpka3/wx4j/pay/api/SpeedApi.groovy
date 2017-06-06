package io.github.btpka3.wx4j.pay.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.pay.WxPayApi.BaseReq
import io.github.btpka3.wx4j.pay.WxPayApi.BaseResp

/**
 * 测速相关API
 */
@CompileStatic
interface SpeedApi extends WxMpApi {

    String API_URI_report = "https://api.mch.weixin.qq.com/payitil/report"

    // ----------------------------------------------

    /**
     * 上报
     */
    ReportResp report(
            ReportReq downloadReq
    )

    static class ReportReq extends BaseReq {

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 设备号 */
        String device_info

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 签名 */
        String sign_type

        /** 签名 */
        String interface_url

        /** 接口耗时 */
        Integer execute_time_

        /** 返回状态码 */
        String return_code

        /** 返回信息 */
        String return_msg

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        /** 商户订单号 */
        String out_trade_no

        /** 访问接口IP */
        String user_ip

        /** 商户上报时间，格式为yyyyMMddHHmmss */
        String time
    }

    static class ReportResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回
        String result_code
    }


}
