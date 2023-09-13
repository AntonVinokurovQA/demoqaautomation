package test;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static utils.PropertyReader.getBrowserType;

public abstract class BaseTest {
    WebDriver driver;

    @BeforeEach
    private void setUp() {
        driver = Driver.getDriver(getBrowserType());
    }

    @AfterEach
    private void tearDown() {
        driver.quit();
    }
}
