package io.github.btpka3.wx4j.mp.api.user

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 删除分组
 */
@CompileStatic
interface DelGroupApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/delete"

    static class Query {
        String access_token
    }

    static class Req {
        Group group

        static class Group {
            String id
        }
    }
}
