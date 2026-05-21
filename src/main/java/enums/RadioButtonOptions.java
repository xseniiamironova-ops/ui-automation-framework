package enums;

import java.util.Arrays;

public enum RadioButtonOptions {
    FIRST("2.1"),
    SECOND("2.2"),
    THIRD("2.3"),
    NO_CHOICE("");

    private final String value;

    RadioButtonOptions (String value) {
        this.value = value;
    }

    public String value () {
        return value;
    }

    public static RadioButtonOptions from(String text) {
        return Arrays.stream(values())
                .filter(e -> e.value.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Неизвестный радиобатон: " + text));
    }
}
