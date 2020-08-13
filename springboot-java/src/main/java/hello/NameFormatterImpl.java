package hello;

import org.springframework.stereotype.Component;

@Component
class NameFormatterImpl implements NameFormatter {
    @Override
    public String format(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
