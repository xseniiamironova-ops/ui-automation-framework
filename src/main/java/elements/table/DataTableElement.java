package elements.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dto.TableData;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class DataTableElement {

    private final SelenideElement dataTable = $("#dataTable");

    private ElementsCollection getLines () {
        return dataTable.$$("tbody tr");
    }

    public List<TableData> getTableData () {
        return getLines().stream()
                .map(line -> new DataTableLine(line).getLineData())
                .toList();
    }

    public void shouldBeEmpty () {
        assertThat(getTableData()).isEmpty();
    }

    public void shouldBeVisible () {
        dataTable.shouldBe(visible);
    }
}
