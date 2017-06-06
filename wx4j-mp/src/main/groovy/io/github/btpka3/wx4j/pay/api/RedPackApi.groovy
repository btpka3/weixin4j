package io.github.btpka3.wx4j.pay.api

import io.github.btpka3.wx4j.pay.WxPayApi
import io.github.btpka3.wx4j.pay.WxPayApi.BaseReq
import io.github.btpka3.wx4j.pay.WxPayApi.BaseResp

/**
 *  红包相关API
 *
 *  参考 ： https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon_sl.php
 */
interface RedPackApi extends WxPayApi {

    String API_URI_sendPlain = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack"
    String API_URI_sendGroup = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack"
    String API_URI_info = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo"

    // ----------------------------------------------

    /**
     * 发放普通红包
     */
    SendPlainResp sendPlain(
            SendPlainReq sendPlainReq
    )

    static class SendPlainReq extends BaseReq {

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 商户订单号 */
        String mch_billno

        /** 商户号 */
        String mch_id

        /** 子商户号 */
        String sub_mch_id

        /** 公众账号appid */
        String wxappid

        /** 触达用户appid */
        String msgappid

        /** 商户名称 */
        String send_name

        /** 用户openid */
        String re_openid

        /** 付款金额 (单位：分) */
        Integer total_amount

        /** 红包发放总人数 */
        Integer total_num

        /** 祝福语 */
        String wishing

        /** Ip地址 */
        String client_ip

        /** 活动名称 */
        String act_name

        /** 备注 */
        String remark

        /**
         * 场景id
         * 发放红包使用场景，红包金额大于200时必传
         *  PRODUCT_1 - 商品促销
         *  PRODUCT_2 - 抽奖
         *  PRODUCT_3 - 虚拟物品兑奖
         *  PRODUCT_4 - 企业内部福利
         *  PRODUCT_5 - 渠道分润
         *  PRODUCT_6 - 保险回馈
         *  PRODUCT_7 - 彩票派奖
         *  PRODUCT_8 - 税务刮奖
         */
        String scene_id

        /**
         * 活动信息
         */
        RiskInfo risk_info

        /** 扣钱方mchid */
        String consume_mch_id

        /**
         * 把值为非空的信息用key=value进行拼接，再进行urlencode
         * urlencode(posttime=xx& mobile =xx&deviceid=xx)
         */
        public static class RiskInfo {

            /** 用户操作的时间戳  */
            String posttime

            /** 业务系统账号的手机号，国家代码-手机号。不需要+号 */
            String mobile

            /** mac 地址或者设备唯一标识 */
            String deviceid

            /** 用户操作的客户端版本 */
            String clientversion
        }
    }

    static class SendPlainResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 签名 */
        String sign

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 商户订单号 */
        String mch_billno

        /** 商户号 */
        String mch_id

        /** 公众账号appid */
        String wxappid

        /** 用户openid */
        String re_openid

        /** 付款金额（单位：分） */
        String total_amount

        /** 发放成功时间 */
        String send_time

        /** 微信单号 */
        String send_listid
    }

    // ----------------------------------------------

    /**
     * 发放普通红包
     */
    SendGroupResp sendGroup(
            SendGroupReq sendGroupReq
    )

    static class SendGroupReq extends BaseReq {

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 商户订单号 */
        String mch_billno

        /** 商户号 */
        String mch_id

        /** 子商户号 */
        String sub_mch_id

        /** 公众账号appid */
        String wxappid

        /** 触达用户appid */
        String msgappid

        /** 商户名称 */
        String send_name

        /** 用户openid */
        String re_openid

        /** 付款金额 (单位：分) */
        Integer total_amount

        /** 红包发放总人数 */
        Integer total_num

        /** 金额设置方式 */
        String amt_type

        /** 红包祝福语 */
        String wishing

        /** 活动名称 */
        String act_name

        /** 备注 */
        String remark

        /** 场景id */
        String scene_id

        /** 活动信息 */
        RiskInfo risk_info

        //  TODO 文档不清
        // /** 资金授权商户号 */
        //String consume_mch_id

        /** 扣钱方mchid */
        String consume_mch_id

        /**
         * 把值为非空的信息用key=value进行拼接，再进行urlencode
         * urlencode(posttime=xx& mobile =xx&deviceid=xx)
         */
        public static class RiskInfo {

            /** 用户操作的时间戳  */
            String posttime

            /** 业务系统账号的手机号，国家代码-手机号。不需要+号 */
            String mobile

            /** mac 地址或者设备唯一标识 */
            String deviceid

            /** 用户操作的客户端版本 */
            String clientversion
        }
    }

    static class SendGroupResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 签名 */
        String sign

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 商户订单号 */
        String mch_billno

        /** 商户号 */
        String mch_id

        /** 公众账号appid */
        String wxappid

        /** 用户openid */
        String re_openid

        /** 付款金额（单位：分） */
        Integer total_amount

        /** 发放成功时间 */
        String send_time

        /** 微信单号 */
        String send_listid
    }

    // ----------------------------------------------

    /**
     * 查询红包记录
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
        String mch_billno

        /** 商户号 */
        String mch_id

        /** Appid */
        String appid

        /** 订单类型  */
        String bill_type
    }


    static class InfoResp extends BaseResp {

        // ----------------------------------------------- 以下字段在return_code为SUCCESS的时候有返回

        /** 签名 */
        String sign

        /** 业务结果 */
        String result_code

        /** 错误代码 */
        String err_code

        /** 错误代码描述 */
        String err_code_des

        // ----------------------------------------------- 以下字段在return_code 和result_code都为SUCCESS的时候有返回

        /** 商户订单号 */
        String mch_billno

        /** 商户号 */
        String mch_id

        /** 红包单号 */
        String detail_id

        /** 红包状态 */
        String status

        /** 发放类型 */
        String send_type

        /** 红包类型 */
        String hb_type

        /** 红包个数  */
        Integer total_num

        /** 红包金额（单位：分） */
        String total_amount

        /** 失败原因 */
        String reason

        /** 红包发送时间 */
        Date send_time

        /** 红包退款时间 */
        Date refund_time

        /** 红包退款金额（单位：分） */
        Integer refund_amount

        /** 祝福语 */
        String wishing

        /** 备注 */
        String remark

        /** 活动名称 */
        String act_name

        /** 裂变红包领取列表 */
        List<HbInfo> hblist

        public static class HbInfo {

            /** 领取红包的Openid */
            String openid

            /** 金额 */
            Integer amount = 0

            /** 接收时间 */
            String rcv_time
        }
    }

}
