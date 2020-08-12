package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class WontWorkGreetingServiceTest {
    // This doesn't set GreetingService's dependencies
    GreetingService gs = new GreetingService();

    @Test
    public void greet() {
        assertEquals("Hello, Foo!", gs.greet("foo"));
    }
}
