package net.kingsilk.qh.common.sms.dayu

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import net.kingsilk.qh.common.sms.dayu.api.query.QueryApi
import net.kingsilk.qh.common.sms.dayu.api.send.SendApi
import net.kingsilk.qh.common.sms.dayu.conf.SmsDayuProperties
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.boot.web.client.RestTemplateCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.web.client.RestTemplate

import java.nio.charset.Charset

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@ActiveProfiles(["ut"])
@SpringBootTest(
        classes = [UtApp],
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@CompileStatic
abstract class BaseTest {

    final String logPrefix = "█" * 40 + " "
    final Logger log = LoggerFactory.getLogger(getClass());

    // see WebClientRestTemplateAutoConfiguration
    TestRestTemplate restTemplate = new TestRestTemplate(TestRestTemplate.HttpClientOption.ENABLE_COOKIES)
//    @Autowired
//    TestRestTemplate restTemplate


    @Autowired
    UtProperties ut

//    @Configuration
//    @EnableConfigurationProperties
    @SpringBootApplication
    static class UtApp {

        @Bean
        SmsDayuProperties smsDayuProperties() {
            return new SmsDayuProperties()
        }


        @Bean
        UtProperties utProperties() {
            return new UtProperties()
        }

        // ------------- 自定义 restTemplate
        @Bean
        @CompileStatic(TypeCheckingMode.SKIP)
        HttpMessageConverters httpMessageConverters() {

            // String 类型 ： ISO-8859-1 -> UTF-8
            return new HttpMessageConverters(true, [
                    new StringHttpMessageConverter(Charset.forName("UTF-8"))
            ])
        }

        @Bean
        ClientHttpRequestFactory clientHttpRequestFactory() {
            HttpClient httpClient = HttpClientBuilder.create()
                    .build();

            // HttpComponentsClientHttpRequestFactory 与日志级别 "logging.level.org.apache.http: DEBUG" 配合
            // 以方便调试 RestTemplate 请求头、响应头
            ClientHttpRequestFactory fac = new HttpComponentsClientHttpRequestFactory(httpClient)
            return fac
        }

        @Bean
        RestTemplateCustomizer myRestTemplateCustomizer(
                ClientHttpRequestFactory clientHttpRequestFactory
        ) {
            return new RestTemplateCustomizer() {

                @Override
                void customize(RestTemplate restTemplate) {
                    restTemplate.setRequestFactory(clientHttpRequestFactory);
                }
            }
        }

        //================

        @Bean
        QueryApi queryApi(
                RestTemplateBuilder restTemplateBuilder,
                SmsDayuProperties props
        ) {
            QueryApi queryApi = new QueryApi()
            queryApi.restTemplate = restTemplateBuilder.build()
            queryApi.props = props
            return queryApi
        }

        @Bean
        SendApi sendApi(
                RestTemplateBuilder restTemplateBuilder,
                SmsDayuProperties props
        ) {
            SendApi api = new SendApi()
            api.restTemplate = restTemplateBuilder.build()
            api.props = props
            return api
        }

    }

}
