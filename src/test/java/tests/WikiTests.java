package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OnbordingScreen;

@DisplayName("Тесты для Википедии")
@Tag("mob")
public class WikiTests extends TestBase{
    @DisplayName("Тест на onboarding screen в приложении Википедии")
    @Test
    void gettingStartedTest() {
        OnbordingScreen screen = new OnbordingScreen();
        screen.visibilityCheckOfForwardButton()
                .clickOnForwardButton()
                .visibilityCheckOfForwardButton()
                .clickOnForwardButton()
                .visibilityCheckOfForwardButton()
                .clickOnForwardButton()
                .visibilityCheckOfDoneButton()
                .clickOnDoneButton();
    }
}