package io.github.btpka3.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef

/**
 * Created by zll on 26/05/2017.
 */
class WxTicket extends Base {

    /**
     * 微信 access token 类型
     */
    WxTicketTypeEnum ticketType;

    /**
     * 微信应用。
     */
    @DBRef
    WxApp wxApp;

    /**
     * 授权方关联的 微信开发者账号。
     * 仅当 type in [PROXY, PROXY_USER] 才有值
     */
    WxDev wxDev;

    /**
     * 授权方 的 APPID。
     * 仅当 type in [PROXY, PROXY_USER] 才有值
     */
    String authorizerAppId;

    /**
     * 用户(人) 的 openId。
     * 仅当 type in [SELF_USER, PROXY_USER] 才有值
     */
    String userOpenId;

//    /**
//     * 前一个 access token.
//     */
//     At preAt;

    /**
     * 当前 access token 信息。
     */
    At at;

    JsApi jsApi;

    /**
     * 微信 access token 相关信息。
     * <p>
     * 参考： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432&token=&lang=zh_CN
     * 微信·公众平台 -> 微信公众平台技术文档 -> 开始开发 -> 获取 access_token
     */
    static class At {

        /**
         * 自动生成的ID。
         * <p>
         * 前端自动生成，应可转换为ObjectId，主要用于查找更新。
         */

        String id;

        /**
         * 过期时间。
         * <p>
         * 获取到 access_token 时，由系统时间 + expiresIn 得到。
         */
        Date expiresAt;

        /**
         * 获取到的凭证。
         */
        @Indexed
        String accessToken;

        /**
         * 凭证有效时间，单位：秒
         */
        Integer expiresIn;

        /**
         * 刷新 Token.
         */
        String refreshToken;

        /**
         * scopes
         */
        Set<String> scopes = new LinkedHashSet<>();


    }

    /**
     * jsTicket
     */
    static class JsApi {

        String id;

        String jsApiTicket;

        /**
         * jsapi_ticket 有效时间，单位：秒
         */
        Integer jatExpiresIn;

        /**
         * 凭证过期时间，由获取时间+有效时间计算的
         */
        Date jatExpiresAt;

    }
}
