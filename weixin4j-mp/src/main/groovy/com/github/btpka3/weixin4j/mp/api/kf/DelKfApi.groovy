package com.github.btpka3.weixin4j.mp.api.kf

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 删除客服帐号
 */
@CompileStatic
interface DelKfApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/customservice/kfaccount/del"

    static class Query {
        String access_token
    }

    static class Req {
        String kf_account
        String nickname
        String password
    }
}
