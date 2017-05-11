package com.github.btpka3.weixin4j.component.api

/**
 * 微信第三方平台相关的API。
 */
interface WxComUrl {

    String COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token"

    String CREATE_PRE_AUTH_CODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode"

    String QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth"

}
