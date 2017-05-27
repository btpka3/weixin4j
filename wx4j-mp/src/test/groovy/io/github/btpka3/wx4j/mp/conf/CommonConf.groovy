package io.github.btpka3.wx4j.mp.conf

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.util.UtProps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 */
@Configuration
@CompileStatic
class CommonConf {

    @Bean
    Map testMap() {
        return new LinkedHashMap()
    }

//    @Bean
//    UtProps utProps() {
//        return new UtProps()
//    }

}
