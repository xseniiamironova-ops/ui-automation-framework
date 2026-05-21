package testData;

import dto.TableData;
import enums.CheckBoxOptions;
import enums.RadioButtonOptions;
import utils.Generate;

import static enums.GenderOptions.*;

public class TestTableData {

    public static TableData validAllFields () {
        return new TableData(
                Generate.randomEmail(),
                Generate.randomString(5),
                MALE,
                CheckBoxOptions.FIRST,
                RadioButtonOptions.FIRST
        );
    }

    public static TableData validWithNoCheckbox () {
        return new TableData (
                Generate.randomEmail(),
                Generate.randomString(6),
                FEMALE,
                CheckBoxOptions.NO_CHOICE,
                RadioButtonOptions.SECOND
        );
    }

    public static TableData validWithAllCheckbox () {
        return new TableData(
                Generate.randomEmail(),
                Generate.randomString(6),
                FEMALE,
                CheckBoxOptions.ALL,
                RadioButtonOptions.THIRD
        );
    }

    public static TableData validWithNoRadioButton () {
        return new TableData(
                Generate.randomEmail(),
                Generate.randomString(6),
                MALE,
                CheckBoxOptions.SECOND,
                RadioButtonOptions.NO_CHOICE
        );
    }

    public static TableData withoutEmail () {
        return new TableData(
                "",
                Generate.randomString(6),
                MALE,
                CheckBoxOptions.FIRST,
                RadioButtonOptions.NO_CHOICE
        );
    }

    public static TableData withoutName () {
        return new TableData(
                Generate.randomEmail(),
                "",
                MALE,
                CheckBoxOptions.FIRST,
                RadioButtonOptions.NO_CHOICE
        );
    }
}
