package com.github.btpka3.weixin4j.mp.api.user

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

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
