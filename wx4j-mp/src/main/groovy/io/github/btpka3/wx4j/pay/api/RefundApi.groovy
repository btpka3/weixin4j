package io.github.btpka3.wx4j.pay.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.pay.WxPayApi.BaseReq
import io.github.btpka3.wx4j.pay.WxPayApi.BaseResp

/**
 * 退款相关API
 */
@CompileStatic
interface RefundApi extends WxMpApi {

    String API_URI_refund = "https://api.mch.weixin.qq.com/secapi/pay/refund"
    String API_URI_query = "https://api.mch.weixin.qq.com/pay/refundquery"

    // ----------------------------------------------

    /**
     * 申请退款
     */
    RefundResp refund(
            RefundReq refundReq
    )

    static class RefundReq extends BaseReq {

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

        /** 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5 */
        String sign_type

        /** 微信订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 商户退款单号 */
        String out_refund_no

        /** 总金额 */
        Integer total_fee

        /** 退款金额 */
        Integer refund_fee

        /** 货币种类 */
        String refund_fee_type

        /**
         * 仅针对老资金流商户使用
         *
         * REFUND_SOURCE_UNSETTLED_FUNDS - 未结算资金退款（默认使用未结算资金退款）
         * REFUND_SOURCE_RECHARGE_FUNDS  - 可用余额退款(限非当日交易订单的退款）
         */
        String refund_account

    }

    static class RefundResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 微信订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 商户退款单号 */
        String out_refund_no

        /** 微信退款单号 */
        String refund_id

//        /** 退款渠道 */
//        String refund_channel

        /** 退款金额 */
        Integer refund_fee

        /** 应结退款金额 */
        Integer settlement_refund_fee

        /** 订单总金额 */
        Integer total_fee

        /** 应结订单金额 */
        Integer settlement_total_fee

        /** 订单金额货币种类 */
        String fee_type

        /** 现金支付金额 */
        Integer cash_fee

        /** 现金支付币种 */
        String cash_fee_type

        /** 现金退款金额 */
        Integer cash_refund_fee

        /** 代金券或立减优惠退款金额 */
        Integer coupon_refund_fee

        /** 代金券或立减优惠使用数量 */
        Integer coupon_refund_count

        /**
         *
         */
        List<Coupon> coupon_refund

        public static class Coupon {

            /**
             * CASH    - 充值代金券
             * NO_CASH - 非充值代金券
             */
            String coupon_type

            /**
             * 单个代金券退款金额
             */
            Integer coupon_refund_fee

            /**
             * 退款代金券ID
             */
            String coupon_refund_id
        }

    }

    // ----------------------------------------------

    /**
     * 查询退款
     */
    QueryResp query(
            QueryReq queryReq
    )

    /**
     *
     * 注意： transaction_id， out_trade_no，out_refund_no，refund_id 为四选一
     */
    static class QueryReq extends BaseReq {

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 签名类型 */
        String sign_type

        /** 微信订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 商户退款单号 */
        String out_refund_no

        /** 微信退款单号 */
        String refund_id
    }

    static class QueryResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 微信支付订单号 */
        String transaction_id

        /** 商户订单号 */
        String out_trade_no

        /** 总金额 */
        Integer total_fee

        /** 应结订单金额 */
        Integer settlement_total_fee

        /** 货币种类 */
        String fee_type

        /** 现金支付金额 */
        Integer cash_fee

        /** 退款笔数 */
        Integer refund_count

        /** 退款记录列表 */
        List<Refund> refundList

        /** 退款记录 */
        public static class Refund {

            /** 商户退款单号 */
            String out_refund_no

            /** 微信退款单号 */
            String refund_id

            /** 退款渠道 */
            String refund_channel

            /** 申请退款金额 */
            Integer refund_fee

            /** 退款金额 */
            Integer settlement_refund_fee

            /** 代金券类型 */
            String coupon_type

            ///** 单个代金券退款金额 */
            //Integer coupon_refund_fee

            /** 退款代金券使用数量 */
            Integer coupon_refund_count

            /**
             * 退款代金券ID
             */
            String coupon_refund_id

            /** 单个代金券退款金额 */
            String coupon_refund_fee

            /** 退款状态 */
            String refund_status

            /**
             * 退款资金来源
             */
            String refund_account

            /**
             * 退款成功时间
             */
            String refund_success_time
        }

    }
}
