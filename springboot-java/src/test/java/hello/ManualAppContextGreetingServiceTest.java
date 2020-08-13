package hello;

import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;

public class ManualAppContextGreetingServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class, LocalTestConfig.class);

    @TestConfiguration
    static class LocalTestConfig {
        @Bean
        public GreetingService greetingService(NameFormatter formatter) {
            return new GreetingService(formatter);
        }
    }

    @Test
    public void greet() {
        GreetingService gs = (GreetingService) context.getBean("greetingService");
        assertEquals("Hello, FORMAT[ryuichi]!", gs.greet("ryuichi"));
    }
}
