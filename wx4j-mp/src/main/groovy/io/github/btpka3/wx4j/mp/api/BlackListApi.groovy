package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 黑名单管理
 */
@CompileStatic
interface BlackListApi extends WxMpApi {

    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist"
    String API_URI_black = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist"
    String API_URI_unblack = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist"

    // ----------------------------------------------
    /**
     * 获取公众号的黑名单列表
     */
    ListResp list(
            String access_token,
            ListReq listReq
    )

    static class ListReq extends BaseReq {
        String begin_openid
    }

    static class ListResp extends BaseResp {

        Integer total
        Integer count
        Data data
        public static class Data {
            List<String> openid
            String next_openid
        }
    }

    // ----------------------------------------------
    /**
     * 拉黑用户
     */
    BlackResp black(
            String access_token,
            BlackReq blackReq
    )

    static class BlackReq extends BaseReq {
        List<String> openid_list  // FIXME 文档与示例不一致
    }

    static class BlackResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 拉黑用户
     */
    UnlackResp unblack(
            String access_token,
            UnlackReq unlackReq
    )

    static class UnlackReq extends BaseReq {
        List<String> openid_list
    }

    static class UnlackResp extends BaseResp {

    }

}
