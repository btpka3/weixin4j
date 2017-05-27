package io.github.btpka3.wx4j.mp.util

import groovy.transform.CompileStatic
import groovy.transform.ToString
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "ut")
@CompileStatic
@ToString(includeNames = true)
class UtProps {

    File dataFile

    // key - wxAppName : 微信公众号、企业号，小程序等的名称
    Map<String, Wx> wx

    static class Wx {

        String appId
        String appSecret
        static class Mp {

        }
    }


}
