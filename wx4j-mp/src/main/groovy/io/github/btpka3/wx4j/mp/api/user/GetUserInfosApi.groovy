package io.github.btpka3.wx4j.mp.api.user

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 批量获取用户基本信息
 *
 * 最多支持一次拉取100条。
 */
@CompileStatic
interface GetUserInfosApi extends WxMpApi<Query, Void, Resp> {

    String API_URI = "https://api.weixin.qq.com/cgi-bin/user/info/batchget"

    static class Query {
        String access_token
    }

    static class Req {
        List<User> user_list

        static class User {

            /**
             * 用户的标识，对当前公众号唯一
             */
            String openid

            /**
             * 用户的语言
             *
             * zh_CN - 简体中文（默认）
             * zh_TW - 繁体中文
             * en    - 英文
             */
            String lang
        }
    }

    static class Resp {

        List<UserInfo> user_info_list

        static class UserInfo {

            /**
             * 用户是否订阅该公众号标识。
             * 值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
             */
            int subscribe

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
             * zh_CN - 简体中文为
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
             * 用户关注时间，为时间戳。
             *
             * 如果用户曾多次关注，则取最后关注时间
             */
            long subscribe_time

            /**
             * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
             */
            String unionid

            /**
             * 公众号运营者对粉丝的备注。
             *
             * 公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
             */
            String remark

            /**
             * 用户所在的分组ID
             */
            long groupid
        }
    }
}
