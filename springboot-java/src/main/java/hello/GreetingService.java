package hello;

import org.springframework.stereotype.Service;

@Service
class GreetingService {
    final NameFormatter formatter;

    public GreetingService(NameFormatter formatter) {
        this.formatter = formatter;
    }

    public String greet(String name) {
        return "Hello, " + formatter.format(name) + "!";
    }
}
