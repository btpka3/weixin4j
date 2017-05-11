package com.github.btpka3.weixin4j.component.api.impl

import com.github.btpka3.weixin4j.component.api.PreAuthCodeApi
import groovy.transform.CompileStatic
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

/**
 * Created by zll on 10/05/2017.
 */
@CompileStatic
class CreatePreAuthCodeImpl implements PreAuthCodeApi {

    private RestTemplate restTemplate

    CreatePreAuthCodeImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate
    }

    static final String WX_COM_AUTH_URL = "https://mp.weixin.qq.com/cgi-bin/componentloginpage"


    String WX_CREATE_PRE_AUTH_CODE_URL = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=xxx"


    PreAuthCodeApi.Resp createPreAuthCode(PreAuthCodeApi.Req req) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(WX_CREATE_PRE_AUTH_CODE_URL)
                .queryParam("component_access_token", "TODO")
                .build()
                .encode("UTF-8")
                .toUri()

//        PreAuthCodeApi.Req req = [
//                component_appid: "TODO"
//        ] as PreAuthCodeApi.Req

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<PreAuthCodeApi.Req> reqEntity = new HttpEntity(req, headers)

        ResponseEntity<PreAuthCodeApi.Resp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                PreAuthCodeApi.Resp)

        PreAuthCodeApi.Resp resp = respEntity.getBody()
    }

    String getAuthUrl() {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(WX_COM_AUTH_URL)
                .queryParam("component_appid", "TODO")
                .queryParam("pre_auth_code", "TODO")
                .queryParam("redirect_uri", "TODO")
                .build()
                .encode("UTF-8")
                .toUri()
        return uri.toString()
    }


}
