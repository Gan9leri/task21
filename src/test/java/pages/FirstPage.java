package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FirstPage {

    SelenideElement forwardButtonOnFirstPage =
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Проверка видимости кнопки Продолжить на первой странице")
    public FirstPage visibilityCheckOfForwardButtonOnFirstPage(){
        forwardButtonOnFirstPage.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить на первой странице")
    public FirstPage clickOnForwardButtonOnFirstPage() {
        forwardButtonOnFirstPage.click();
        return this;
    }
}
