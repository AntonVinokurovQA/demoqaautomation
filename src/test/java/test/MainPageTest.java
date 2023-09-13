package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.MainPage;

public class MainPageTest extends BaseTest {
    @Test
    @DisplayName("Open main page and check logo")
    public void mainPageOpen() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .checkLogo();
    }
}
