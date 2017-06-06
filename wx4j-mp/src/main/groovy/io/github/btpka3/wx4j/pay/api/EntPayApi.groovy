package io.github.btpka3.wx4j.pay.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.pay.WxPayApi.BaseReq
import io.github.btpka3.wx4j.pay.WxPayApi.BaseResp

/**
 * 企业付款相关API
 */
@CompileStatic
interface EntPayApi extends WxMpApi {

    String API_URI_transfer = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"
    String API_URI_info = " \thttps://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo"

    // ----------------------------------------------

    /**
     * 企业付款
     */
    TransferResp transfer(
            TransferReq transferReq
    )

    static class TransferReq extends BaseReq {

        /** 公众账号ID */
        String mch_appid

        /** 商户号 */
        String mchid

        /** 设备号 */
        String device_info

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 商户订单号 */
        String partner_trade_no

        /** 用户openid */
        String openid

        /** 校验用户姓名选项 */
        String check_name

        /** 收款用户姓名 */
        String re_user_name

        /** 金额 (单位：分) */
        Integer amount

        /** 企业付款描述信息 */
        String desc

        /** Ip地址 */
        String spbill_create_ip
    }

    static class TransferResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 商户appid */
        String mch_appid

        /** 商户号 */
        String mchid

        /** 设备号 */
        String device_info

        /** 随机字符串 */
        String nonce_str

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 商户订单号 */
        String partner_trade_no

        /** 微信订单号 */
        String payment_no

        /** 微信支付成功时间 */
        Date payment_time
    }

    // ----------------------------------------------

    /**
     * 查询企业付款
     */
    InfoResp info(
            InfoReq infoReq
    )

    static class InfoReq extends BaseReq {

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 商户订单号 */
        String partner_trade_no

        /** 商户号 */
        String mchid

        /** 商户号的appid  */
        String appid
    }

    static class InfoResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 商户订单号 */
        String partner_trade_no

        /** 商户号 */
        String mch_id

        /** 付款单号 */
        String detail_id

        /** 商户appid */
        String mch_appid

        /** 转账状态 */
        String status

        /** 失败原因 */
        String reason

        /** 收款用户openid */
        String openid

        /** 收款用户姓名 */
        String transfer_name

        /** 付款金额 */
        String payment_amount

        /** 转账时间 */
        String transfer_time

        /** 付款描述 */
        String desc

    }
}
