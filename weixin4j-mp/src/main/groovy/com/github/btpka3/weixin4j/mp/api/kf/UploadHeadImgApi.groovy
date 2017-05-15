package com.github.btpka3.weixin4j.mp.api.kf

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 删除客服帐号
 */
@CompileStatic
interface UploadHeadImgApi extends WxMpApi<Query, Void, Void> {

    String API_URI = "https://api.weixin.qq.com/customservice/kfaccount/del"

    static class Query {
        String access_token
        String kf_account
    }


}
