package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GreetingService {
    @Autowired
    NameFormatter formatter;

    public String greet(String name) {
        return "Hello, " + formatter.format(name) + "!";
    }
}
