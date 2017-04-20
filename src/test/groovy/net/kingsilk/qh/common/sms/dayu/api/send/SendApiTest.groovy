package net.kingsilk.qh.common.sms.dayu.api.send

import net.kingsilk.qh.common.admin.stub.BaseTest
import net.kingsilk.qh.common.sms.dayu.BaseTest
import net.kingsilk.qh.common.sms.dayu.api.send.SendApi
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class SendApiTest extends BaseTest {

    @Autowired
    SendApi sendApi

    @Test
    void selfAt01() {

        // 内部测试
        String appId = "wxf9f2b8b1a506c068"
        Object respJson = wxApi.selfAt(appId)



        sendApi.

        assertThat(respJson).isNotNull()
    }
}
