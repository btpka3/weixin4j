package com.github.btpka3.weixin4j.component.web.client

/**
 *
 */
class WxComApiException extends RuntimeException {

    int errcode

    String errmsg


    WxComApiException(int errcode, String errmsg) {
        this.errcode = errcode
        this.errmsg = errmsg
    }


}
