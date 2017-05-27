package io.github.btpka3.wx4j.mp

import io.github.btpka3.wx4j.mp.api.AppAtApi
import io.github.btpka3.wx4j.mp.api.JsApiTicketApi
import io.github.btpka3.wx4j.mp.api.SnsUserApi
import io.github.btpka3.wx4j.mp.api.UserAtApi
import io.github.btpka3.wx4j.mp.util.UtProps
import io.github.btpka3.wx4j.mp.util.UtUtils
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner)
//@ActiveProfiles(["default", "ut"])
@SpringBootTest(
        classes = [Wx4jMpUtApp],
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
abstract class BaseTest {

    final String logPrefix = "█" * 40 + " "
    final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UtProps utProps


    @Autowired
    UtUtils utUtils

    @Autowired
    AppAtApi appAtApi

    @Autowired
    JsApiTicketApi jsApiTicketApi

    @Autowired
    SnsUserApi snsUserApi

    @Autowired
    UserAtApi userAtApi

//    @LocalServerPort
//    int port;

    TestRestTemplate restTemplate = new TestRestTemplate(TestRestTemplate.HttpClientOption.ENABLE_COOKIES)
//    @Autowired
//    TestRestTemplate wwwRestTemplate

//
//    @Before
//    void load() {
//        utUtils.loadData()
//    }
//
//    @After
//    void save() {
//        utUtils.saveData()
//    }


}
