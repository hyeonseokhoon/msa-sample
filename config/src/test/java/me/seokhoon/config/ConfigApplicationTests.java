package me.seokhoon.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.cloud.config.server.git.uri=file://${java.io.tmpdir}/config-repo",
        "spring.cloud.config.server.git.default-label=main",
        "spring.cloud.config.server.git.skip-ssl-validation=true"
})
class ConfigApplicationTests {

    @Test
    void contextLoads() {
    }

}
