package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Foo foo;

    HelloController(Foo foo) {
        this.foo = foo;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/foo")
    public String foo() {
        return foo.getName();
    }

}
