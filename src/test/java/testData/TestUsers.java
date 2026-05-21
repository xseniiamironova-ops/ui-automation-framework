package testData;

import dto.User;

import static utils.PropertyLoader.getProperty;

public class TestUsers {

    private static final String VALID_LOGIN = getProperty("user_login");
    private static final String VALID_PASSWORD = getProperty("user_password");

    public static final User VALID_USER =
            new User(
                    VALID_LOGIN,
                    VALID_PASSWORD
            );

    public static final User INVALID_EMAIL_USER =
            new User(
                    "not_valid_format",
                    VALID_PASSWORD
            );

    public static final User INVALID_PASSWORD_USER =
            new User(
                    VALID_LOGIN,
                    "wrong_pass"
            );

    public static final User NOT_EXISTING_USER =
            new User(
                    "unknown@test.com",
                    "pass"
            );

    public static final User USER_WITHOUT_EMAIL =
            new User(
                    "",
                    VALID_PASSWORD
            );

    public static final User USER_WITHOUT_PASSWORD =
            new User(
                    VALID_LOGIN,
                    ""
            );
}
