package com.github.btpka3.weixin4j.component.api.impl

import com.github.btpka3.weixin4j.component.api.ComponentTokenApi
import groovy.transform.CompileStatic
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

import static com.github.btpka3.weixin4j.component.api.ComponentTokenApi.Req
import static com.github.btpka3.weixin4j.component.api.ComponentTokenApi.Resp

/**
 *
 */
@CompileStatic
@Deprecated
class ComponentTokenApiImpl implements ComponentTokenApi {

    private RestTemplate restTemplate

    ComponentTokenApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }


    Resp query(Void empty, Req req) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URI)
                .build()
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<Req> reqEntity = new HttpEntity(req, headers)

        ResponseEntity<Resp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                Resp)

        Resp resp = respEntity.getBody()
        return resp
    }

//    String getAuthUrl() {
//        URI uri = UriComponentsBuilder
//                .fromHttpUrl(WX_COM_AUTH_URL)
//                .queryParam("component_appid", "TODO")
//                .queryParam("pre_auth_code", "TODO")
//                .queryParam("redirect_uri", "TODO")
//                .build()
//                .encode("UTF-8")
//                .toUri()
//        return uri.toString()
//    }


}
