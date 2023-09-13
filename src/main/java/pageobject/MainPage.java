package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.PropertyReader.getBaseUrl;

public class MainPage extends BasePage {
    @FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
    private WebElement logo;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(getBaseUrl());

        return this;
    }

    public boolean checkLogo() {
        return logo.isDisplayed();
    }
}
