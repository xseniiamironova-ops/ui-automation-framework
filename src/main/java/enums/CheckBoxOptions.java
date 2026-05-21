package enums;

import java.util.Arrays;

public enum CheckBoxOptions {

    FIRST("1.1"),
    SECOND("1.2"),
    ALL("1.1, 1.2"),
    NO_CHOICE("Нет");

    public final String value;

    CheckBoxOptions (String value) {
        this.value = value;
    }

    public String value () {
        return value;
    }

    public static CheckBoxOptions from(String text) {
        return Arrays.stream(values())
                .filter(e -> e.value.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unknown gender: " + text));
    }
}
