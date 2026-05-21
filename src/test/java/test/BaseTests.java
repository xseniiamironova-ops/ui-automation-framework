package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({AllureTestNg.class})
public abstract class BaseTests {

    protected static final String BASE_PATH = "file:///" + System.getProperty("user.dir") + "/src/test/resources/qa-test.html";

    @BeforeTest(alwaysRun = true)
    public void setUpWebDriver () {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.savePageSource = true;
        Configuration.screenshots = true;

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @AfterMethod
    public void tearDown () {
        closeWebDriver();
    }
}
