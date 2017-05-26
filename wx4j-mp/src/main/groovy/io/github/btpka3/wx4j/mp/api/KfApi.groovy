package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic

/**
 * 添加客服帐号
 */
@CompileStatic
interface KfApi extends WxMpApi {

    String API_URI_add = "https://api.weixin.qq.com/customservice/kfaccount/add"

    String API_URI_del = "https://api.weixin.qq.com/customservice/kfaccount/del"

    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist"

    String API_URI_update = "https://api.weixin.qq.com/customservice/kfaccount/update"

    String API_URI_uploadHeadImg = "XXX"

    static class UpdateReq {
        String kf_account
        String nickname
        String password
    }

    AddResp add(String access_token, AddReq addReq)

    DelResp del(String access_token, DelReq delReq)

    ListResp list(String access_token)

    UpdateResp update(String access_token, UpdateReq updateReq)

    UploadHeadImgResp uploadHeadImg(
            String access_token,
            String kf_account,
            byte[] imgBytes)


    static class AddReq {
        String kf_account
        String nickname
        String password
    }

    static class AddResp extends BaseResp {
    }

    static class DelReq {
        String kf_account
        String nickname
        String password
    }

    static class DelResp extends BaseResp {
    }

    static class ListResp {

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

    static class UpdateResp extends BaseResp {
    }

    static class UploadHeadImgResp extends BaseResp {
    }


}