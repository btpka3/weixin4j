package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import org.springframework.core.io.Resource

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 客服帐号管理
 */
@CompileStatic
interface KfApi extends WxMpApi {

    String API_URI_add = "https://api.weixin.qq.com/customservice/kfaccount/add"
    String API_URI_invite = "https://api.weixin.qq.com/customservice/kfaccount/inviteworker"
    String API_URI_del = "https://api.weixin.qq.com/customservice/kfaccount/del"
    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist"
    String API_URI_listOnline = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflistt"
    String API_URI_update = "https://api.weixin.qq.com/customservice/kfaccount/update"
    String API_URI_uploadHeadImg = "https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg"

    // ----------------------------------------------
    /**
     * 添加客服帐号
     */
    AddResp add(
            String access_token,
            AddReq addReq
    )

    static class AddReq extends BaseReq {
        String kf_account
        String nickname
        //String password
    }

    static class AddResp extends BaseResp {
    }

    // ----------------------------------------------

    /**
     * 邀请绑定客服帐号
     */
    InviteResp invite(
            String access_token,
            InviteReq inviteReq
    )

    static class InviteReq extends BaseReq {

        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        String kf_account

        /**
         * 接收绑定邀请的客服微信号
         */
        String invite_wx
    }


    static class InviteResp extends BaseResp {
    }


    // ----------------------------------------------
    /**
     * 删除客服帐号
     */
    DelResp del(
            String access_token,
            String kf_account
    )

    static class DelResp extends BaseResp {
    }

    // ----------------------------------------------
    /**
     * 获取所有客服账号
     */
    ListResp list(
            String access_token
    )


    static class ListResp extends BaseResp {

        List<Kf> kf_list

        static class Kf {
            /**
             * 完整客服账号，格式为：账号前缀@公众号微信号
             */
            String kf_account

            /**
             * 客服昵称
             */
            String kf_nick

            /**
             * 客服工号
             */
            String kf_id


            String kf_headimgurl
        }
    }

    // ----------------------------------------------

    /**
     * 获取所有在线客服账号
     */
    ListOnlineResp listOnline(
            String access_token
    )


    static class ListOnlineResp extends BaseResp {

        List<Kf> kf_online_list

        static class Kf {
            /**
             * 完整客服账号，格式为：账号前缀@公众号微信号
             */
            String kf_account

            /**
             * 客服在线状态
             * 1 - web 在线
             */
            Integer status


            /**
             * 客服工号
             */
            String kf_id

            /**
             * 客服当前正在接待的会话数
             */
            Integer accepted_case
        }
    }

    // ----------------------------------------------
    /**
     * 修改客服帐号
     */
    UpdateResp update(
            String access_token,
            UpdateReq updateReq
    )

    static class UpdateReq extends BaseReq {
        String kf_account

        /**
         * 客服昵称，最长16个字
         */
        String nickname
    }

    static class UpdateResp extends BaseResp {
    }

    // ----------------------------------------------
    /**
     * 设置客服帐号的头像
     */
    UploadHeadImgResp uploadHeadImg(
            String access_token,
            String kf_account,
            Resource media
    )

    static class UploadHeadImgResp extends BaseResp {
    }

}
