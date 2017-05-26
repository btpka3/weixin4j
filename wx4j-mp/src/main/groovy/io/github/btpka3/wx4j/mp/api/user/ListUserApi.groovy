package io.github.btpka3.wx4j.mp.api.user

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.WxMpApi

/**
 * 查询所有分组
 */
@CompileStatic
interface ListUserApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/user/get"

    static class Query {
        String access_token

        /**
         * 第一个拉取的OPENID，不填默认从头开始拉取
         */
        String next_openid
    }


    static class Resp {

        /**
         * 关注该公众账号的总用户数
         */
        int total

        /**
         * 拉取的OPENID个数，最大值为10000
         */
        int count

        /**
         * 列表数据，OPENID的列表
         */
        Data data

        /**
         * 拉取列表的最后一个用户的OPENID
         */
        String next_openid


        static class Data {
            List<String> openid
        }
    }
}
