package com.github.btpka3.weixin4j.component.web.client

import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException

/**
 * Created by zll on 11/05/2017.
 */
class MyMessageConverter implements HttpMessageConverter{
    @Override
    boolean canRead(Class clazz, MediaType mediaType) {
        return false
    }

    @Override
    boolean canWrite(Class clazz, MediaType mediaType) {
        return false
    }

    @Override
    List<MediaType> getSupportedMediaTypes() {
        return null
    }

    @Override
    Object read(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null
    }

    @Override
    void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
