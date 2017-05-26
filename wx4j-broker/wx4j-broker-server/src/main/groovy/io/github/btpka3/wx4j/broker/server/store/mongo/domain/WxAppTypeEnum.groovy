package io.github.btpka3.wx4j.broker.server.store.mongo.domain

/**
 * 微信号类型。
 */
public enum WxAppTypeEnum {

    APP("APP", "微信移动应用"),
    WEB("WEB", "微信网站应用"),

    DYH("DYH", "微信订阅号"),
    FWH("FWH", "微信服务号"),
    QYH("QYH", "微信企业号"),
    XCX("XCX", "微信小程序"),
    TEST("TEST", "微信测试号"),


    /**
     * 微信·开放平台 -> 管理中心 -> 公众号第三方平台 ： 列表中的单个 "公众号第三方平台" 信息。
     * <p>
     * https://open.weixin.qq.com
     * <p>
     * https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
     */
    COM("COM", "微信公众号第三方平台"),

    /**
     * https://qy.weixin.qq.com/app
     */
    CORP("CORP","微信企业号第三方服务")

    private final String code;
    private final String desp;

    WxAppTypeEnum(String code, String desp) {
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
