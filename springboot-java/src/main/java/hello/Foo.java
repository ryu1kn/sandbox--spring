package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    @Value("${foo.name}")
    private String name;

    public String getName() {
        return this.name;
    }
}
