package io.github.btpka3.wx4j.mp.api.kf

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.WxMpApi

/**
 * 添加客服帐号
 */
@CompileStatic
interface AddKfApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/customservice/kfaccount/add"

    static class Query {
        String access_token
    }

    static class Req {
        String kf_account
        String nickname
        String password
    }
}
