package io.github.btpka3.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.mapping.DBRef

/**
 *
 */
class WxDev extends Base {

    /**
     * 注册邮箱。
     */
    private String email;

    /**
     * 微信号的类型。
     */
    @DBRef
    private Set<WxApp> wxApps = new LinkedHashSet<>();

    /**
     * 备注
     */
    private String memo;

}
