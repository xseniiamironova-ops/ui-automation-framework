package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class AddDataPopupWindow {

    private final SelenideElement popupWindowText = $(".uk-modal-content");
    private final SelenideElement popupWindowOkButton = $(".uk-modal-close");

    public void clickOk () {
        popupWindowOkButton.click();
    }

    public void shouldHaveText (String expected) {
        popupWindowText.shouldBe(visible);

        assertThat(popupWindowText.text())
                .isEqualTo(expected);
    }
}
