package com.github.btpka3.weixin4j.mp.api.user

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 创建分组
 *
 * 一个公众账号，最多支持创建100个分组。
 */
@CompileStatic
interface CreateGroupApi extends WxMpApi<Query, Req, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/create"

    static class Query {
        String access_token
    }

    static class Req {
        Group group

        static class Group {
            String name
        }
    }

    static class Resp {
        Group group

        static class Group {
            String id
            String name
        }
    }
}
