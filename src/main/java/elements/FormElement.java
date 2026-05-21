package elements;

import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxOptions;
import enums.GenderOptions;
import enums.RadioButtonOptions;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static enums.GenderOptions.MALE;

public class FormElement {

    private final SelenideElement emailTextField = $("#dataEmail");
    private final SelenideElement nameTextField = $("#dataName");

    private final SelenideElement genderSelector = $("#dataGender");

    private final SelenideElement firstCheckBox = $("#dataCheck11");
    private final SelenideElement secondCheckBox = $("#dataCheck12");

    private final SelenideElement firstRadioButton = $("#dataSelect21");
    private final SelenideElement secondRadioButton = $("#dataSelect22");
    private final SelenideElement thirdRadioButton = $("#dataSelect23");

    private final SelenideElement addButton = $("#dataSend");

    public void fillEmail (String email) {
        emailTextField.setValue(email);
    }

    public void fillName (String name) {
        nameTextField.setValue(name);
    }

    public void selectGender (GenderOptions option) {
        genderSelector.selectOption(option.value());
    }

    public void selectCheckBox (CheckBoxOptions option) {
        switch (option) {

            case FIRST ->
                    firstCheckBox.click();

            case SECOND ->
                    secondCheckBox.click();

            case ALL -> {
                    firstCheckBox.click();
                    secondCheckBox.click();}

            case NO_CHOICE -> {}
        }
    }

    public void selectRadioButton (RadioButtonOptions option) {
        switch (option) {

            case FIRST  ->
                    firstRadioButton.click();

            case SECOND ->
                    secondRadioButton.click();

            case THIRD  ->
                    thirdRadioButton.click();

            case NO_CHOICE -> {}
        }
    }

    public void add () {
        addButton.click();
    }

    public void clearForm () {
        emailTextField.clear();
        nameTextField.clear();

        if(firstCheckBox.isSelected()) firstCheckBox.setSelected(false);
        if(secondCheckBox.isSelected()) secondCheckBox.setSelected(false);
    }

    public void shouldBeTextFieldEmpty () {
        var soft = new SoftAssertions();

        soft.assertThat(emailTextField.getValue()).isEmpty();
        soft.assertThat(nameTextField.getValue()).isEmpty();

        soft.assertAll();
    }

    public void shouldBeCheckBoxUnchecked () {
        firstCheckBox.shouldNotBe(selected);
        secondCheckBox.shouldNotBe(selected);
    }

    public void shouldBeGenderMaleSelected () {
        genderSelector.shouldHave(text(MALE.value()));
    }

    public void shouldBeRadioButtonUnselected () {
        firstRadioButton.shouldNotBe(selected);
        secondRadioButton.shouldNotBe(selected);
        thirdRadioButton.shouldNotBe(selected);
    }
}
