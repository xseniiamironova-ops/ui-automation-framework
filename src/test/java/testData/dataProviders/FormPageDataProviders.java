package testData.dataProviders;

import org.testng.annotations.DataProvider;

import static testData.TestTableData.*;

public class FormPageDataProviders {

    @DataProvider(name = "correctFormData")
    public Object[][] correctCredentials () {
        return new Object[][] {
                { validAllFields() },
                { validWithNoCheckbox() },
                { validWithAllCheckbox() },
                { validWithNoRadioButton() }
        };
    }
}
