package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GreetingService {
    @Autowired
    lateinit var formatter: NameFormatter

    fun greet(name: String) = "Hello, ${formatter.format(name)}!"
}
