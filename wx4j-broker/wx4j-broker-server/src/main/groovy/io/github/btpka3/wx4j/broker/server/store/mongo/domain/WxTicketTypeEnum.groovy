package io.github.btpka3.wx4j.broker.server.store.mongo.domain;

/**
 * 微信号类型。
 */
public enum WxTicketTypeEnum {

    SELF("SELF", "公众号自身获取Access Token"),
    SELF_USER("USER", "公众号自身获取用户授权的 User Access Token "),
    PROXY("PROXY", "公众号第三方平台代替授权方获取Access Token"),
    PROXY_USER("PROXY", "公众号第三方平台代替授权方获取 User 授权的 Access Token");


    private final String code;
    private final String desp;

    WxTicketTypeEnum(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    public String getCode() {
        return code;
    }

    public String getDesp() {
        return desp;
    }

    public final String getDescription() {
        return desp;
    }

}
