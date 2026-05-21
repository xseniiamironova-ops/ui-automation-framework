package test.auth;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.FormPage;
import test.BaseTests;

import static com.codeborne.selenide.Selenide.open;
import static testData.TestUsers.*;

public class AuthPageTests extends BaseTests {

    private final AuthPage authPage = new AuthPage();
    private final FormPage formPage = new FormPage();

    @BeforeMethod
    public void openAuthPage () {
        open(BASE_PATH);
        authPage.shouldBeVisible();
    }

    // ------------------------------ POSITIVE

    @Test
    @Description("Успешная авторизация с валидными данными")
    public void successfulLoginWithValidData () {
        authPage
                .fillCredentialsFor(VALID_USER)
                .clickSubmit();

        formPage.shouldBeVisibleDataTable();
    }

    @Test
    @Description("Успешная авторизация после закрытия сообщения об ошибке")
    public void successfulLoginAfterCloseCredentialErrorMessage () {
        authPage
                .fillCredentialsFor(INVALID_PASSWORD_USER)
                .clickSubmit()
                .closeCredentialErrorMessage()
                .fillCredentialsFor(VALID_USER)
                .clickSubmit();

        formPage.shouldBeVisibleDataTable();
    }

    // ------------------------------ NEGATIVE

    @Test
    @Description("Отображение ошибки при вводе неверного пароля")
    public void unsuccessfulLoginWithNotValidPassword () {
        authPage
                .fillCredentialsFor(INVALID_PASSWORD_USER)
                .clickSubmit();

        authPage.shouldShowCredentialError();
    }

    @Test
    @Description("Отображение ошибки при авторизации несуществующего пользователя")
    public void unsuccessfulLoginWithNotExistUser () {
        authPage
                .fillCredentialsFor(NOT_EXISTING_USER)
                .clickSubmit();

        authPage.shouldShowCredentialError();
    }

    @Test
    @Description("Отображение ошибки при авторизации без пароля")
    public void unsuccessfulLoginWithoutPassword () {
        authPage
                .fillCredentialsFor(USER_WITHOUT_PASSWORD)
                .clickSubmit();

        authPage.shouldShowCredentialError();
    }

    @Test
    @Description("Отображение ошибки при авторизации без E-mail")
    public void unsuccessfulLoginWithoutEmail () {
        authPage
                .fillCredentialsFor(USER_WITHOUT_EMAIL)
                .clickSubmit();

        authPage.shouldShowEmailFormatError();
    }

    @Test
    @Description("Отображение ошибки при вводе email в неверном формате")
    public void unsuccessfulLoginWithNotCorrectEmailFormat () {
        authPage
                .fillCredentialsFor(INVALID_EMAIL_USER)
                .clickSubmit();

        authPage.shouldShowEmailFormatError();
    }

    @Test
    @Description("Отображение ошибки при авторизации с пустыми полями")
    public void unsuccessfulLoginWithEmptyFields () {
        authPage.clickSubmit();

        authPage.shouldShowEmailFormatError();
    }

    @Test
    @Description("Повторная авторизация невозможна после появления ошибки email или пароля")
    public void unsuccessfulLoginAfterCredentialErrorMessage () {
        authPage
                .fillCredentialsFor(INVALID_PASSWORD_USER)
                .clickSubmit()
                .closeCredentialErrorMessage()
                .clickSubmit();

        authPage.shouldShowEmailFormatError();
    }

    @Test
    @Description("Повторная авторизация невозможна после появления и закрытия ошибки формата email")
    public void unsuccessfulLoginAfterFormatErrorMessage () {
        authPage
                .fillCredentialsFor(INVALID_EMAIL_USER)
                .clickSubmit()
                .closeEmailFormatErrorMessage()
                .clickSubmit();

        authPage.shouldShowEmailFormatError();
    }
}
