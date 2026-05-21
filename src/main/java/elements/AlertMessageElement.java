package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class AlertMessageElement {

    private final SelenideElement alertMessageElement;

    public AlertMessageElement (String css) {
        alertMessageElement = $(css);
    }

    public void closeAlert () {
        alertMessageElement.$(".uk-alert-close.uk-close").click();
    }

    public void shouldHaveText (String expected) {
        alertMessageElement.shouldBe(visible);

        assertThat(alertMessageElement.text())
                .isEqualTo(expected);
    }
}
