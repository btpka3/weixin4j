package io.github.btpka3.wx4j.mp.api.impl

import io.github.btpka3.wx4j.mp.BaseTest
import io.github.btpka3.wx4j.mp.api.JsApiTicketApi
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class JsApiTicketApiImplTest extends BaseTest {


    @Test
    void getTicket01() {

        String at = utUtils.getWxMpAt("wxTest2")
        JsApiTicketApi.GetTicketResp resp = jsApiTicketApi.getTicket(at)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.errcode == null || resp.errcode == 0).isTrue()
        assertThat(resp.ticket).isNotNull()
    }
}
