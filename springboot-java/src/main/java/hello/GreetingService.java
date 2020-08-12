package hello;

import org.springframework.stereotype.Service;

@Service
class GreetingService {
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
