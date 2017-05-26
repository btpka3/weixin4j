package io.github.btpka3.wx4j.mp.api.user

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 查询用户所在分组
 */
@CompileStatic
interface FindGroupByUserApi extends WxMpApi<Query, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/get"

    static class Query {
        String access_token
    }

    static class Req {
        String openid
    }

    static class Resp {
        String groupid
    }
}
