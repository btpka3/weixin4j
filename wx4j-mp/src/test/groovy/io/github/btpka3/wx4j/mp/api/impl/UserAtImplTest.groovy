package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.BaseTest
import io.github.btpka3.wx4j.mp.api.AppAtApi
import io.github.btpka3.wx4j.mp.api.UserAtApi.GetUserAtResp
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class UserAtImplTest extends BaseTest {


    @Test
    void createAuthUrl01() {
        String appId = utProps.wx.wxTest2.appId

        // 注意：该网址需要在微信公众号管理后台中 网页授权域 中设置的域名保持一致
        String redirectUrl = "https://kingsilk.net/testAuth"

        String authUrl = userAtApi.createAuthUrl(
                appId,
                redirectUrl,
                "snsapi_userinfo",
                "randomStr99898")

        log.debug("authUrl = " + authUrl)
        assertThat(authUrl).isNotNull()
    }


    @Test
    void getUserAt01() {
        String appId = utProps.wx.wxTest2.appId
        String appSecret = utProps.wx.wxTest2.appSecret

        // 需手动介入。
        // 1. 微信 - 公众平台 - 开发 - 开发者工具 - web开发者工具 ： 进入 ： 绑定开发人员微信号
        // 2. 下载 微信Web开发者工具：
        //      https://mp.weixin.qq.com/debug/wxadoc/dev/devtools/devtools.html
        // 3. 登录 微信Web开发者工具并: 访问 testCase createAuthUrl01() 打印的URL。
        //    授权后，复制URL中的code 的值，并粘贴至此处
        String code = "0311Gj6k2EKj9J01UD5k2n8h6k21Gj6a"

        assertThat(code).isNotNull()

        GetUserAtResp resp = userAtApi.getUserAt(
                appId,
                appSecret,
                code
        )

        utUtils.saveUserAt("wxTest2", resp.openid, resp.access_token)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.access_token).isNotNull()
    }
}
