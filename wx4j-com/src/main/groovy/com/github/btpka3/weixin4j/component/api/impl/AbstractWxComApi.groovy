package com.github.btpka3.weixin4j.component.api.impl

import com.github.btpka3.weixin4j.component.api.WxComApi
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate

/**
 *
 */
@CompileStatic
@Slf4j
abstract class AbstractWxComApi<Query, Req, Resp> implements WxComApi {


    RestTemplate restTemplate

    AbstractWxComApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }

//    Resp query(Query query, Req req) {
//        String respStr = queryAsString(query, req)
//
//        for(HttpMessageConverter messageConverter: restTemplate.getMessageConverters()){
//            if (messageConverter.canRead(Resp, null)) {
//                if (log.isDebugEnabled()) {
//                    log.debug("Reading [" + Resp.getName() + "] using [" + messageConverter + "]");
//                }
//                return (Resp) messageConverter.read(Resp, responseWrapper);
//            }
//        }
//    }
}
