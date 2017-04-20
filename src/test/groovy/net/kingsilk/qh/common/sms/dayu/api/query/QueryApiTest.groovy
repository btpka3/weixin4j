package net.kingsilk.qh.common.sms.dayu.api.query

import net.kingsilk.qh.common.sms.dayu.BaseTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 *
 */
class QueryApiTest extends BaseTest {

    @Autowired
    QueryApi queryApi

    @Test
    void query01() {

        QueryReq req = new QueryReq()

        req.setRec_num("18069855776")
        req.setQuery_date(ZonedDateTime.now(ZoneId.of("Asia/Shanghai"))
                .minusDays(29)
                .format(DateTimeFormatter.ofPattern("yyyyMMdd")))

        req.setCurrent_page("1")
        req.setPage_size("10")


        QueryResp resp = queryApi.query(req)

        println resp
    }
}
