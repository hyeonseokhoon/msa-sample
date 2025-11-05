package me.seokhoon.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.cloud.gateway.server.webflux.discovery.locator.enabled=false",
        "eureka.client.enabled=false"
})
class GatewayApplicationTests {

    @Test
    void contextLoads() {
    }

}
