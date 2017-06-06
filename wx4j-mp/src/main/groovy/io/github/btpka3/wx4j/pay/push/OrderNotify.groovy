package io.github.btpka3.wx4j.pay.push

/**
 *
 */

class OrderNotify implements PayNotify {

    /** 返回状态码 */
    String return_code

    /** 返回信息 */
    String return_msg

    // ----------------------------------------------- 以下字段在 return_code 为 SUCCESS 的时候有返回

    /** 公众账号 ID */
    String appid

    /** 商户号 */
    String mch_id

    /** 设备号 */
    String device_info

    /** 随机字符串 */
    String nonce_str

    /** 签名 */
    String sign

    /** 签名类型 */
    String sign_type

    /** 业务结果 */
    String result_code

    /** 错误代码 */
    String err_code

    /** 错误代码描述 */
    String err_code_des

    // ----------------------------------------------- 以下字段在 return_code 和 result_code 都为 SUCCESS 的时候有返回

    /** 用户标识 */
    String openid

    /** 是否关注公众账号 */
    String is_subscribe

    /** 交易类型 */
    String trade_type

    /** 付款银行 */
    String bank_type

    /** 总金额 */
    Integer total_fee

    /** 应结订单金额 */
    Integer settlement_total_fee

    /** 货币种类 */
    String fee_type

    /** 现金支付金额 */
    Integer cash_fee

    /** 现金支付货币类型 */
    String cash_fee_type

    /** 现金券金额 */
    Integer coupon_fee

    /** 代金券使用数量 */
    Integer coupon_count

    /** 代金券列表 */
    List<Coupon> coupons

    /** 微信支付订单号 */
    String transaction_id

    /** 商户订单号 */
    String out_trade_no

    /** 商家数据包 */
    String attach

    /** 支付完成时间 */
    String time_end

    public static class Coupon {

        /** 代金券类型 */
        String coupon_type

        /** 代金券ID */
        String coupon_id

        /** 单个代金券支付金额 */
        Integer coupon_fee
    }
}
