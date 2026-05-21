package enums;

public enum Messages {

    ADD_DATA_MESSAGE("Данные добавлены."),

    CREDENTIAL_ERROR("Неверный E-Mail или пароль"),
    EMAIL_FORMAT_ERROR("Неверный формат E-Mail"),
    NAME_EMPTY_ERROR("Поле имя не может быть пустым");

    private final String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public String value () {
        return msg;
    }
}
