package com.github.btpka3.weixin4j.component.web.client

import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse

/**
 * Created by zll on 11/05/2017.
 */
class SaveStringInterceptor implements ClientHttpRequestInterceptor {
    @Override
    ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        ClientHttpResponse resp = execution.execute(request, body)

        return resp
    }
}
