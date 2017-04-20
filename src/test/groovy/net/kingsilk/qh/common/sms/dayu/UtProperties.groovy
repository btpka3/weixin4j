package net.kingsilk.qh.common.sms.dayu

import groovy.transform.CompileStatic
import groovy.transform.ToString
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ut")
class UtProperties {

    QhOAuth qhOAuth
    QhCommon qhCommon

    static class QhOAuth {

        Wap wap

        static class Wap {

            String url
            String accessTokenUrl

            String clientId
            String clientSecret
            List<String> scopes

//            /**
//             * 认证服务器的主URL
//             */
//            String url
//            String accessTokenUri
//            String userAuthorizationUri
//            String checkTokenUri
//            String realm
        }
    }

    static class QhCommon {
        Admin admin

        static class Admin {
            String resourceId
            //String url
        }
    }


}
