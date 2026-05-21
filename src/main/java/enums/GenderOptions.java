package enums;

import java.util.Arrays;

public enum GenderOptions {

    MALE("Мужской"),
    FEMALE("Женский");

    private final String gender;

    GenderOptions(String gender) {
        this.gender = gender;
    }

    public String value () {
        return gender;
    }

    public static GenderOptions from(String text) {
        return Arrays.stream(values())
                .filter(e -> e.gender.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Неизвестный пол: " + text));
    }
}
