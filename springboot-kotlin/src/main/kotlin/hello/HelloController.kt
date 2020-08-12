package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class HelloController @Autowired constructor(private val greetingService: GreetingService) {

    val counter = AtomicLong()

    @GetMapping("/person")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
        Greeting(counter.incrementAndGet(), greetingService.greet(name))

    data class Greeting(val id: Long, val content: String)
}
