package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.BaseTest
import io.github.btpka3.wx4j.mp.api.AppAtApi
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class AppAtImplTest extends BaseTest {


    @Test
    void getAppAt01() {
        String appId = utProps.wx.wxTest2.appId
        String appSecret = utProps.wx.wxTest2.appSecret

        AppAtApi.GetAppAtResp resp = appAtApi.getAppAt(appId, appSecret)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.errcode == null || resp.errcode == 0).isTrue()
        assertThat(resp.access_token).isNotNull()
    }
}
