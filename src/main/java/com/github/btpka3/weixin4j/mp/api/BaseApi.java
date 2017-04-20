package com.github.btpka3.weixin4j.mp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 *
 */
public abstract class BaseApi {

    public final Logger log = LoggerFactory.getLogger(getClass());
    private OAuth2RestTemplate restTemplate;
    private QcaStubProperties props;


    public final Logger getLog() {
        return log;
    }

    public OAuth2RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public QcaStubProperties getProps() {
        return props;
    }

    public void setProps(QcaStubProperties props) {
        this.props = props;
    }


}
