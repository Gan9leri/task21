package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SecondPage {
    SelenideElement forwardButtonOnSecondPage =
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Проверка видимости кнопки Продолжить на второй странице")
    public SecondPage visibilityCheckOfForwardButtonOnSecondPage(){
        forwardButtonOnSecondPage.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить на второй странице")
    public SecondPage clickOnForwardButtonOnSecondPage() {
        forwardButtonOnSecondPage.click();
        return this;
    }
}
