package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class, GreetingServiceTestWithListingAllConfig.LocalTestConfig.class})
public class GreetingServiceTestWithListingAllConfig {
    static class LocalTestConfig {
        @Bean
        public GreetingService greetingService(NameFormatter formatter) {
            return new GreetingService(formatter);
        }
    }

    @Autowired
    GreetingService gs;

    @Test
    public void greet() {
        assertEquals("Hello, FORMAT[ryuichi]!", gs.greet("ryuichi"));
    }
}
