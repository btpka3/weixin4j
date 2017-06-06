package io.github.btpka3.wx4j.pay.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.pay.WxPayApi.BaseReq
import io.github.btpka3.wx4j.pay.WxPayApi.BaseResp

/**
 * 订单相关API
 */
@CompileStatic
interface OrderApi extends WxMpApi {

    String API_URI_create = "https://api.mch.weixin.qq.com/pay/unifiedorder"
    String API_URI_close = "https://api.mch.weixin.qq.com/pay/closeorder"
    String API_URI_query = "https://api.mch.weixin.qq.com/pay/orderquery"

    // ----------------------------------------------

    /**
     * 统一下单
     */
    CreateResp create(
            CreateReq createReq
    )

    static class CreateReq extends BaseReq {

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

        /** 商品描述 */
        String body

        /** 商品详情 */
        String detail

        /** 附加数据 */
        String attach

        /** 商户订单号 */
        String out_trade_no

        /** 货币类型 */
        String fee_type

        /** 总金额 */
        Integer total_fee

        /** 终端IP */
        String spbill_create_ip

        /** 交易起始时间 */
        String time_start

        /** 交易结束时间 */
        String time_expire

        /** 商品标记 */
        String goods_tag

        /** 通知地址 */
        String notify_url

        /**
         * 交易类型
         * 取值如下：JSAPI，NATIVE，APP等
         */
        String trade_type

        /** 商品ID */
        String product_id

        /** 指定支付方式 */
        String limit_pay

        /** 用户标识 */
        String openid
    }

    static class CreateResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

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

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 交易类型 */
        String trade_type

        /** 预支付交易会话标识 */
        String prepay_id

        /** 二维码链接 */
        String code_url

    }


    // ----------------------------------------------

    /**
     * 查询订单
     */
    CloseResp query(
            QueryReq queryReq
    )
    static class QueryReq extends BaseReq {

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 微信订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5 */
        String sign_type
    }

    static  class QueryResp extends BaseResp {


        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code、result_code、trade_state都为SUCCESS的时候有返回
        // 如trade_state不为 SUCCESS，则只返回 out_trade_no（必传）和attach（选传）。

        /** 设备号 */
        String device_info

        /** 用户标识 */
        String openid

        /** 是否关注公众账号 */
        String is_subscribe

        /** 交易类型 */
        String trade_type

        /** 交易状态 */
        String trade_state

        /** 付款银行 */
        String bank_type

        /** 总金额 */
        Integer total_fee

        /** 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。 */
        Integer settlement_total_fee

        /** 货币种类 */
        String fee_type

        /** 现金支付金额 */
        Integer cash_fee

        /** 现金支付货币类型 */
        String cash_fee_type

        /** 代金券或立减优惠金额 */
        Integer coupon_fee

        /** 代金券或立减优惠使用数量  */
        Integer coupon_count

        /** 代金券或立减优惠 列表 */
        List<Coupon> couponList

        /** 微信支付订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 商家数据包 */
        String attach

        /** 支付完成时间 */
        String time_end

        /** 交易状态描述  */
        String trade_state_desc

        static class Coupon {

            /** 代金券类型 */
            String coupon_type

            /** 代金券ID */
            List<String> coupon_id

            /** 单个代金券或立减优惠支付金额 */
            Integer coupon_fee
        }
    }

    // ----------------------------------------------

    /**
     * 关闭订单
     */
    CloseResp close(
            CloseReq closeReq
    )

    static class CloseReq extends BaseReq {

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 商户订单号 */
        String out_trade_no

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /**
         * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
         */
        String sign_type
    }

    static class CloseResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /**
         * 业务结果
         */
        String result_code

        /**
         * 对于业务执行的详细描述
         */
        String result_msg

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

    }
}
