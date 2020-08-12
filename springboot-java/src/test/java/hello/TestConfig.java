package hello;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    NameFormatter formatter() {
        return new NameFormatter();
    }
}
