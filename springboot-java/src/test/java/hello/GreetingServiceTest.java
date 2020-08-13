package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class GreetingServiceTest {
    @Autowired
    GreetingService gs;

    @Test
    public void greet() {
        assertEquals("Hello, FORMAT[ryuichi]!", gs.greet("ryuichi"));
    }
}
