package io.github.btpka3.wx4j.mp.conf

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.api.*
import io.github.btpka3.wx4j.mp.api.impl.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestOperations

/**
 *
 */
@Configuration
@CompileStatic
class WxMpApiConf {

    @Bean
    AppAtApi appAtApiImpl(RestOperations restTemplate) {
        return new AppAtApiImpl(restTemplate)
    }

    @Bean
    JsApiTicketApi jsApiTicketApi(RestOperations restTemplate) {
        return new JsApiTicketApiImpl(restTemplate)
    }

    @Bean
    SnsUserApi snsUserApi(RestOperations restTemplate) {
        return new SnsUserApiImpl(restTemplate)
    }

    @Bean
    UserAtApi userAtApi(RestOperations restTemplate) {
        return new UserAtApiImpl(restTemplate)
    }
}
