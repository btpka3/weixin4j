package io.github.btpka3.wx4j.mp.api.qrcode

import io.github.btpka3.wx4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 通过ticket换取二维码
 */
@CompileStatic
interface GetQRcodeImgApi extends WxMpApi<Query, Void, byte[]> {

    String API_URI = "https://mp.weixin.qq.com/cgi-bin/showqrcode"

    static class Query {
        String ticket
    }

}
