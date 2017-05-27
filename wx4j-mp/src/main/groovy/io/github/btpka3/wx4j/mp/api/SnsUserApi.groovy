package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 拉取用户信息(需scope为 snsapi_userinfo)
 */
@CompileStatic
interface SnsUserApi extends WxMpApi {

    String API_URI_info = "https://api.weixin.qq.com/sns/userinfo"

    // lang = "zh_CN"
    /**
     * 获取用户的信息。
     * 优点：用户无需关注微公众号
     * 缺点：用户必须手动点击授权按钮
     *
     * @param access_token 代表用户授权的 at
     * @param openid
     * @param lang
     * @return
     */
    InfoResp info(String access_token,
                  String openid,
                  String lang)

    static class InfoResp extends BaseResp {

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
