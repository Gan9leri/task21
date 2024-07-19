package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FourthPage {

    SelenideElement doneButton =
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверка видимости кнопки Начать на четвертой странице")
    public FourthPage visibilityCheckOfDoneButtonOnFourthPage(){
        doneButton.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Начать на четвертой странице")
    public FourthPage clickOnDoneButtonOnFourthPage(){
        doneButton.click();
        return this;
    }

}
