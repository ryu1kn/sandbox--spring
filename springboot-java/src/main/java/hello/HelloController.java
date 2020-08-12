package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Person person;
    private final GreetingService greetingService;

    HelloController(Person person, GreetingService service) {
        this.person = person;
        this.greetingService = service;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/person")
    public String person() {
        return greetingService.greet(person.getName());
    }

}
