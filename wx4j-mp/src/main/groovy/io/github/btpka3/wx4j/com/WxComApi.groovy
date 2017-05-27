package io.github.btpka3.wx4j.com

import groovy.json.JsonOutput
import io.github.btpka3.wx4j.core.WxApi;

/**
 * 微信 - 开放平台 - 第三方平台相关的API。
 */
interface WxComApi extends WxApi {

    /**
     *
     */
    abstract class BaseReq implements Serializable {

        public static final long serialVersionUID = 1L


        @Override
        String toString() {
            return JsonOutput.toJson(this)
        }
    }
    /**
     *
     */
    abstract class BaseResp implements Serializable {

        public static final long serialVersionUID = 1L

        int errcode
        String errmsg

        /**
         * 注意：仅仅是以 JSON 的形式反映当前绑定的数据。可能不匹配微信服务器实际返回的内容。
         * 微信服务器实际返回的内容，建议使用  apache http client ，
         * 开启 logger "org.apache.http.wire" DEBUG 级别的日志。
         *
         * @return
         */
        @Override
        String toString() {
            return JsonOutput.toJson(this)
        }
    }
}
