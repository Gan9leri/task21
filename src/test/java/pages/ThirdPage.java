package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ThirdPage {
    SelenideElement forwardButtonOnThirdPage =
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Проверка видимости кнопки Продолжить на третьей странице")
    public ThirdPage visibilityCheckOfForwardButtonOnThirdPage(){
        forwardButtonOnThirdPage.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить на третьей странице")
    public ThirdPage clickOnForwardButtonOnThirdPage() {
        forwardButtonOnThirdPage.click();
        return this;
    }
}
