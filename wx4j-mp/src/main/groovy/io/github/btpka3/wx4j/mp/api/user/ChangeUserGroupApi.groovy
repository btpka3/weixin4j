package io.github.btpka3.wx4j.mp.api.user

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 移动用户分组
 */
@CompileStatic
interface ChangeUserGroupApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/groups/members/update"

    static class Query {
        String access_token
    }

    static class Req {
        String openid
        String to_groupid
    }


}
