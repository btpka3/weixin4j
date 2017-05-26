package io.github.btpka3.wx4j.mp.api.user

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 批量移动用户分组
 */
@CompileStatic
interface ChangeUsersGroupApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate"

    static class Query {
        String access_token
    }

    static class Req {

        List<String> openid_list

        String to_groupid
    }
}
