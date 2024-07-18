package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnbordingScreen {
    SelenideElement forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
                    doneButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверка видимости кнопки Продолжить")
    public OnbordingScreen visibilityCheckOfForwardButton(){
        forwardButton.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить")
    public OnbordingScreen clickOnForwardButton(){
        forwardButton.click();
        return this;
    }

    @Step("Проверка видимости кнопки Начать")
    public OnbordingScreen visibilityCheckOfDoneButton(){
        doneButton.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Начать")
    public OnbordingScreen clickOnDoneButton(){
        doneButton.click();
        return this;
    }

}