package com.github.btpka3.weixin4j.component.api

import groovy.transform.CompileStatic
import org.springframework.web.client.RestTemplate

/**
 * Created by zll on 10/05/2017.
 *
 * @see UriComponentsBuilder
 */
@CompileStatic
class WxComApiFactory {


    RestTemplate restTemplate


    public <T> T createApi(Class<T> clazz) {

    }

    AuthorizerTokenApi authorizerTokenApi() {
//        return new AuthorizerTokenApiImpl(restTemplate)
    }
}
