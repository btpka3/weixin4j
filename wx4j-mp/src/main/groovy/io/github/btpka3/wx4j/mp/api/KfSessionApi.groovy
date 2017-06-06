package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 客服会话控制
 */
@CompileStatic
interface KfSessionApi extends WxMpApi {

    String API_URI_create = "https://api.weixin.qq.com/customservice/kfsession/create"
    String API_URI_close = "https://api.weixin.qq.com/customservice/kfsession/close"
    String API_URI_getByOpenId = "https://api.weixin.qq.com/customservice/kfsession/getsession"
    String API_URI_listByKf = "https://api.weixin.qq.com/customservice/kfsession/getsessionlist"
    String API_URI_getWaitList = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase"

    // ----------------------------------------------
    /**
     * 创建会话。
     *
     * 如果该客服和用户会话已存在，则直接返回0
     * 指定的客服帐号必须已经绑定微信号且在线。
     */
    CreateResp create(
            String access_token,
            CreateReq createReq
    )

    static class CreateReq extends BaseReq {
        String kf_account

        /**
         * 粉丝的openid
         */
        String openid
    }

    static class CreateResp extends BaseResp {
    }

    // ----------------------------------------------

    /**
     * 关闭会话
     */
    CloseResp close(
            String access_token,
            CloseReq closeReq
    )

    static class CloseReq extends BaseReq {
        String kf_account

        /**
         * 粉丝的openid
         */
        String openid
    }

    static class CloseResp extends BaseResp {
    }

    // ----------------------------------------------

    /**
     * 获取客户会话状态
     */
    GetByOpenIdResp getByOpenId(
            String access_token,
            String openid
    )

    static class GetByOpenIdResp extends BaseResp {

        Long createtime

        String kf_account
    }

    // ----------------------------------------------

    /**
     * 获取客服会话列表
     */
    ListByKfResp listByKf(
            String access_token,
            String kf_account
    )

    static class ListByKfResp extends BaseResp {

        List<Session> sessionlist

        public static class Session {
            Long createtime
            String openid
        }
    }

    // ----------------------------------------------

    /**
     * 获取未接入会话列表
     */
    GetWaitListResp getWaitList(
            String access_token
    )

    static class GetWaitListResp extends BaseResp {

        /**
         * 未接入会话数量
         */
        Integer count

        /**
         * 未接入会话列表，最多返回100条数据，按照来访顺序
         */
        List<WaitInfo> waitcaselist

        public static class WaitInfo {

            /**
             * 粉丝的最后一条消息的时间
             */
            Long latest_time
            String openid
        }
    }
}
