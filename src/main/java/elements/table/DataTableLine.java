package elements.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dto.TableData;

import java.util.List;

public class DataTableLine {

    private final SelenideElement line;

    public DataTableLine(SelenideElement line) {
        this.line = line;
    }

    public TableData getLineData () {
        ElementsCollection lineElement = line.$$("td");

        List <String> cells = lineElement.stream()
                .map(SelenideElement::getText)
                .toList();

        return TableData.fromTable(cells);
    }
}
