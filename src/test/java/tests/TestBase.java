package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulationDriver;
import drivers.RealDeviceDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        //Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browser = RealDeviceDriver.class.getName();
        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        else if ("real".equals(System.getProperty("deviceHost"))){
            Configuration.browser = RealDeviceDriver.class.getName();
        }
        else if ("emulation".equals(System.getProperty("deviceHost"))){
            Configuration.browser = EmulationDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}