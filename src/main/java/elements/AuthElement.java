package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthElement {

    private final SelenideElement emailTextField = $("#loginEmail");
    private final SelenideElement passwordTextField = $("#loginPassword");

    private final SelenideElement enterButton = $("#authButton");

    public void fillEmailTextField (String email) {
        emailTextField.setValue(email);
    }

    public void fillPasswordTextField (String password) {
        passwordTextField.setValue(password);
    }

    public void submit () {
        enterButton.click();
    }

    public void shouldBeVisible () {
        emailTextField.shouldBe(visible);
    }
}
