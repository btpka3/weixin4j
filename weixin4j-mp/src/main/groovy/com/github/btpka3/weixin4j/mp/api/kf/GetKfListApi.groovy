package com.github.btpka3.weixin4j.mp.api.kf

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 修改客服帐号
 */
@CompileStatic
interface GetKfListApi extends WxMpApi<Query, Void, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist"

    static class Query {
        String access_token
    }

    static class Resp {

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
}
