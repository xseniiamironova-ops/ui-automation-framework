package pages;

import dto.TableData;
import elements.AddDataPopupWindow;
import elements.AlertMessageElement;
import elements.FormElement;
import elements.table.DataTableElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static enums.Messages.*;

public class FormPage {

    private final FormElement form = new FormElement();
    private final DataTableElement dataTable = new DataTableElement();
    private final AddDataPopupWindow addDataPopupWindow = new AddDataPopupWindow();

    private final AlertMessageElement emptyNameErrorMessage = new AlertMessageElement("#blankNameError");
    private final AlertMessageElement emailFormatErrorMessage = new AlertMessageElement("#emailFormatError");

    // ------------------------------ ACTIONS

    @Step("Добавить новый элемент в таблицу")
    public void addNewTableElement (TableData record) {
        fillFormFields(record);
        clickAdd();
        clickOk();
    }

    @Step("Заполнить все данные анкеты")
    public FormPage fillFormFields (TableData record) {
        form.fillEmail(record.email());
        form.fillName(record.name());
        form.selectGender(record.gender());
        form.selectCheckBox(record.firstChoice());
        form.selectRadioButton(record.secondChoice());
        return this;
    }

    @Step("Нажать кнопку Добавить")
    public void clickAdd () {
        form.add();
    }

    @Step("Нажать Ok в всплывающем окне")
    public void clickOk () {
        addDataPopupWindow.clickOk();
    }

    @Step("Очистка формы")
    public FormPage clearForm () {
        form.clearForm();
        return this;
    }

    // ------------------------------ ASSERTIONS (VOID)

    @Step("Проверить, что текст всплывающего окна = '{ADD_DATA_MESSAGE.value()}'")
    public void shouldAppearAddingDataMessagePopup () {
        addDataPopupWindow.shouldHaveText(ADD_DATA_MESSAGE.value());
    }

    @Step("Проверить, что в строке {lineNumber} корректно отображается элеменет")
    public void shouldContainCorrectNewElement (TableData expectedElement) {
        List<TableData> elements = dataTable.getTableData();
        TableData actual = elements.getLast();

        var soft = new SoftAssertions();

        soft.assertThat(actual.email()).isEqualTo(expectedElement.email());
        soft.assertThat(actual.name()).isEqualTo(expectedElement.name());
        soft.assertThat(actual.gender().value()).isEqualTo(expectedElement.gender().value());
        soft.assertThat(actual.firstChoice().value()).isEqualTo(expectedElement.firstChoice().value());
        soft.assertThat(actual.secondChoice().value()).isEqualTo(expectedElement.secondChoice().value());

        soft.assertAll();
    }

    @Step("Проверить, что отображается сообщение об ошибке 'Поле имя не может быть пустым'")
    public void shouldShowEmptyNameError () {
        emptyNameErrorMessage.shouldHaveText(NAME_EMPTY_ERROR.value());
    }

    @Step("Проверить, что отображается сообщение об ошибке 'Неверный формат E-Mail'")
    public void shouldShowEmailFormatError () {
        emailFormatErrorMessage.shouldHaveText(EMAIL_FORMAT_ERROR.value());
    }

    @Step("Проверить, что форма в базовом состоянии")
    public void shouldHaveBaseState () {
        form.shouldBeTextFieldEmpty();
        form.shouldBeCheckBoxUnchecked();
        form.shouldBeGenderMaleSelected();
        form.shouldBeRadioButtonUnselected();

        dataTable.shouldBeEmpty();
    }

    @Step("Проверить, что открыта страница с анкетой")
    public void shouldBeVisibleDataTable () {
        dataTable.shouldBeVisible();
    }
}
