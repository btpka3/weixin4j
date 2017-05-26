package io.github.btpka3.wx4j.mp.api.user

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.WxMpApi

/**
 * 设置备注名
 */
@CompileStatic
interface UpdateRemarkApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/delete"

    static class Query {
        String access_token
    }

    static class Req {
        String openid
        String remark
    }
}
