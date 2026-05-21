package pages;

import dto.User;
import elements.AlertMessageElement;
import elements.AuthElement;
import io.qameta.allure.Step;

import static enums.Messages.CREDENTIAL_ERROR;
import static enums.Messages.EMAIL_FORMAT_ERROR;

public class AuthPage {

      private final AuthElement authFormElement = new AuthElement();

      private final AlertMessageElement credentialErrorMessage = new AlertMessageElement("#invalidEmailPassword");
      private final AlertMessageElement emailFormatErrorMessage = new AlertMessageElement("#emailFormatError");

      // ------------------------------ ACTIONS

      @Step("Заполнить поля данными пользователя")
      public AuthPage fillCredentialsFor (User user) {
            authFormElement.fillEmailTextField(user.email());
            authFormElement.fillPasswordTextField(user.password());
            return this;
      }

      @Step("Нажать кнопку 'Вход'")
      public AuthPage clickSubmit () {
            authFormElement.submit();
            return this;
      }

      @Step("Закрыть сообщение об ошибке email или пароля")
      public AuthPage closeCredentialErrorMessage () {
            credentialErrorMessage.closeAlert();
            return this;
      }

      @Step("Закрыть сообщение об ошибке формата email")
      public AuthPage closeEmailFormatErrorMessage () {
            emailFormatErrorMessage.closeAlert();
            return this;
      }

      // ------------------------------ ASSERTIONS (VOID)

      @Step("Проверить, что отображается сообщение об ошибке 'Неверный формат E-mail'")
      public void shouldShowEmailFormatError () {
            emailFormatErrorMessage.shouldHaveText(EMAIL_FORMAT_ERROR.value());
      }


      @Step("Проверить, что отображается сообщение об ошибке 'Неверный E-Mail или пароль'")
      public void shouldShowCredentialError () {
            credentialErrorMessage.shouldHaveText(CREDENTIAL_ERROR.value());
      }

      @Step("Проверить, что открыта страница авторизации")
      public void shouldBeVisible () {
            authFormElement.shouldBeVisible();
      }
}
