package test.form;

import dto.TableData;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.FormPage;
import test.BaseTests;
import testData.TestTableData;
import testData.dataProviders.FormPageDataProviders;

import static com.codeborne.selenide.Selenide.open;
import static testData.TestUsers.VALID_USER;

public class FormPageTests extends BaseTests {

    private final AuthPage authPage = new AuthPage();
    private final FormPage formPage = new FormPage();

    @BeforeMethod
    public void openAuthPageAndLogin () {
        open(BASE_PATH);
        authPage.shouldBeVisible();

        authPage
                .fillCredentialsFor(VALID_USER)
                .clickSubmit();

        formPage.shouldBeVisibleDataTable();
    }

    // ------------------------------ POSITIVE

    @Test
    @Description("Анкета отображается в базовом состоянии при первом открытии")
    public void verifyBaseFormState () {
        formPage.shouldHaveBaseState();
    }

    @Test(dataProviderClass = FormPageDataProviders.class,
          dataProvider = "correctFormData")
    @Description("Новый элемент корректно добавляется в таблицу анкеты")
    public void successfulAddElementInTable (TableData record) {
        formPage.addNewTableElement(record);

        formPage.shouldContainCorrectNewElement(record);
    }

    @Test
    @Description("При добавлении нового элемента появляется уведомление об успешной операции")
    public void successfulAddDataPopupAppear () {
        var record = TestTableData.validWithNoCheckbox();

        formPage
                .fillFormFields(record)
                .clickAdd();

        formPage.shouldAppearAddingDataMessagePopup();
    }

    @Test
    @Description("Несколько элементов корректно добавляются в таблицу анкеты")
    public void successfulAddHBtreeElementsInTable () {
        var record_1 = TestTableData.validWithNoRadioButton();
        var record_2 = TestTableData.validAllFields();
        var record_3 = TestTableData.validWithNoCheckbox();

        formPage.addNewTableElement(record_1);

        formPage.shouldContainCorrectNewElement(record_1);

        formPage
                .clearForm()
                .addNewTableElement(record_2);

        formPage.shouldContainCorrectNewElement(record_2);

        formPage
                .clearForm()
                .addNewTableElement(record_3);

        formPage.shouldContainCorrectNewElement(record_3);
    }

    // ------------------------------ NEGATIVE

    @Test
    @Description("Отображение ошибки при добавлении элемента с пустым E-mail")
    public void unsuccessfulAddWithEmptyEmailField () {
        var record = TestTableData.withoutEmail();

        formPage
                .fillFormFields(record)
                .clickAdd();

        formPage.shouldShowEmailFormatError();
    }

    @Test
    @Description("Отображение ошибки при добавлении элемента с пустым Именем")
    public void unsuccessfulAddWithEmptyNameField () {
        var record = TestTableData.withoutName();

        formPage
                .fillFormFields(record)
                .clickAdd();

        formPage.shouldShowEmptyNameError();
    }
}
