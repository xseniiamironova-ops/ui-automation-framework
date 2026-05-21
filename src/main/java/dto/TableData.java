package dto;

import enums.CheckBoxOptions;
import enums.GenderOptions;
import enums.RadioButtonOptions;

import java.util.List;

public record TableData (
    String email,
    String name,
    GenderOptions gender,
    CheckBoxOptions firstChoice,
    RadioButtonOptions secondChoice
) {

    public static TableData fromTable (List<String> element) {
        return new TableData (
                element.get(0),
                element.get(1),
                GenderOptions.from(element.get(2)),
                CheckBoxOptions.from(element.get(3)),
                RadioButtonOptions.from(element.get(4))
        );
    }
}
