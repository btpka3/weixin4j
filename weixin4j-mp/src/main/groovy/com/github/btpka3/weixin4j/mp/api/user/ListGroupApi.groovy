package com.github.btpka3.weixin4j.mp.api.user

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 查询所有分组
 */
@CompileStatic
interface ListGroupApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/get"

    static class Query {
        String access_token
    }


    static class Resp {
        List<Group> groups

        static class Group {
            String id
            String name
            int count
        }
    }
}
