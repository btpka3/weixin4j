package com.github.btpka3.weixin4j.mp.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wx.mp")
public class WxMpProperties {



    private String url;


}
