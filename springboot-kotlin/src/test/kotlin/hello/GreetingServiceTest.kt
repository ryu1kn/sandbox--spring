package hello;

import junit.framework.Assert.assertEquals
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner::class)
@SpringBootTest
class GreetingServiceTest {
    @Autowired
    lateinit var gs: GreetingService

    @Test
    fun greet() {
        assertEquals("Hello, Ryuichi!", gs.greet("ryuichi"));
    }
}
