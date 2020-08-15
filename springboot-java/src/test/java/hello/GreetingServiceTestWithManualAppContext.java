package hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTestWithManualAppContext {
    static class LocalTestConfig {
        @Bean
        public GreetingService greetingService(NameFormatter formatter) {
            return new GreetingService(formatter);
        }
    }

    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class, LocalTestConfig.class);

    GreetingService gs = (GreetingService) context.getBean("greetingService");

    @Test
    public void greet() {
        assertEquals("Hello, FORMAT[ryuichi]!", gs.greet("ryuichi"));
    }
}
