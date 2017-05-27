package io.github.btpka3.wx4j.mp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration

@Configuration
//@EnableConfigurationProperties
@SpringBootApplication()
//@CompileStatic
class Wx4jMpUtApp {
    static void main(String[] args) throws Exception {
        SpringApplication.run(Wx4jMpUtApp.class, args)
    }
}
