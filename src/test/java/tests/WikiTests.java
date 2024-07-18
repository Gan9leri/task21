package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты для Википедии")
@Tag("mob")
public class WikiTests extends TestBase{
    @Test
    void gettingStartedTest() {
        step("Первый экран и клик", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Новые способы исследований"));
        });
        step("Второй экран и клик", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Списки для чтения с синхронизацией"));
        });
        step("Третий экран и клик", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Данные и конфиденциальность"));
        });
        step("Четвертый экран и клик", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/search_container"))
                    .shouldHave(visible);
        });

    }
}