package io.github.btpka3.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef

/**
 *
 */
class WxJsApiTicket extends Base {


    /**
     * 微信 access token 类型
     */
    private WxTicketTypeEnum ticketType;

    /**
     * 微信应用。
     */
    @DBRef
    private WxApp wxApp;

    /**
     * 授权方关联的 微信开发者账号。
     * 仅当 type in [PROXY, PROXY_USER] 才有值
     */
    private WxDev wxDev;

    /**
     * 授权方 的 APPID。
     * 仅当 type in [PROXY, PROXY_USER] 才有值
     */
    private String authorizerAppId;

    /**
     * 用户(人) 的 openId。
     * 仅当 type in [SELF_USER, PROXY_USER] 才有值
     */
    private String userOpenId;

//    /**
//     * 前一个 access token.
//     */
//    private At preAt;

    /**
     * 当前 access token 信息。
     */
    private At at;

    private JsApi jsApi;

    /**
     * 微信 access token 相关信息。
     * <p>
     * 参考： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432&token=&lang=zh_CN
     * 微信·公众平台 -> 微信公众平台技术文档 -> 开始开发 -> 获取 access_token
     */
    public static class At {

        /**
         * 自动生成的ID。
         * <p>
         * 前端自动生成，应可转换为ObjectId，主要用于查找更新。
         */

        private String id;

        /**
         * 过期时间。
         * <p>
         * 获取到 access_token 时，由系统时间 + expiresIn 得到。
         */
        private Date expiresAt;

        /**
         * 获取到的凭证。
         */
        @Indexed
        private String accessToken;

        /**
         * 凭证有效时间，单位：秒
         */
        private Integer expiresIn;

        /**
         * 刷新 Token.
         */
        private String refreshToken;

        /**
         * scopes
         */
        private Set<String> scopes = new LinkedHashSet<>();

        // ------------------------ 自动生成的 getter、 setter

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getExpiresAt() {
            return expiresAt;
        }

        public void setExpiresAt(Date expiresAt) {
            this.expiresAt = expiresAt;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public Set<String> getScopes() {
            return scopes;
        }

        public void setScopes(Set<String> scopes) {
            this.scopes = scopes;
        }
    }

    /**
     * jsTicket
     */
    public static class JsApi {

        private String id;

        private String jsApiTicket;

        /**
         * jsapi_ticket 什么时间获取的
         */
        private Date jatCreatedTime;

        /**
         * jsapi_ticket 有效时间，单位：秒
         */
        private Integer jatExpiresIn;

        /**
         * 凭证过期时间，由获取时间+有效时间计算的
         */
        private Date jatExpiresAt;
        /////////////////////////////////////

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJsApiTicket() {
            return jsApiTicket;
        }

        public void setJsApiTicket(String jsApiTicket) {
            this.jsApiTicket = jsApiTicket;
        }

        public Date getJatCreatedTime() {
            return jatCreatedTime;
        }

        public void setJatCreatedTime(Date jatCreatedTime) {
            this.jatCreatedTime = jatCreatedTime;
        }

        public Integer getJatExpiresIn() {
            return jatExpiresIn;
        }

        public void setJatExpiresIn(Integer jatExpiresIn) {
            this.jatExpiresIn = jatExpiresIn;
        }

        public Date getJatExpiresAt() {
            return jatExpiresAt;
        }

        public void setJatExpiresAt(Date jatExpiresAt) {
            this.jatExpiresAt = jatExpiresAt;
        }
    }
}
