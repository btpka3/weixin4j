package com.github.btpka3.weixin4j.mp.api.auth

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 拉取用户信息(需scope为 snsapi_userinfo)
 */
@CompileStatic
interface GetSnsUserInfoApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/sns/userinfo"

    static class Query {
        String access_token
        String openid
        String lang = "zh_CN"
    }

    static class Resp {

        /**
         * 用户的标识，对当前公众号唯一
         */
        String openid

        /**
         * 用户的昵称
         */
        String nickname

        /**
         * 用户的性别。
         * 1 - 男性
         * 2 - 女性
         * 0 - 未知
         */
        int sex

        /**
         * 用户的语言
         *
         * zh_CN - 简体中文（默认）
         * zh_TW - 繁体中文
         * en    - 英文
         */
        String language

        /**
         * 用户所在城市
         */
        String city

        /**
         * 用户所在省份
         */
        String province

        /**
         * 用户所在国家
         */
        String country

        /**
         * 用户头像。
         *
         * 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
         * 用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
         */
        String headimgurl

        /**
         * 用户特权信息
         */
        List<String> privilege



        /**
         * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
         */
        String unionid

    }
}
