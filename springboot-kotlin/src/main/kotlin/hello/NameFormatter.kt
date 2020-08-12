package hello;

import org.springframework.stereotype.Component;

@Component
class NameFormatter {
    fun format(name: String) =
        name.substring(0, 1).toUpperCase() + name.substring(1)
}
