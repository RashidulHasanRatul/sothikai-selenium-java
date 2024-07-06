package com.shothikai.tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.shothikai.config.config;
import com.shothikai.drivers.driverFactory;
import com.shothikai.pages.loginPage;

public class loginTest {
    private static final Logger log = LoggerFactory.getLogger(loginTest.class);
    private WebDriver driver;
    private loginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = driverFactory.getDriver("chrome");
        driver.get(config.BASE_URL);
        loginPage = new loginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.clickSigninButton();
        loginPage.enterUsername("test@gmail.com");
        loginPage.enterPassword("1234");
        loginPage.clickLoginButton();
        // Add assertions here to verify successful login
    }

    @AfterMethod
    public void tearDown() {
        driverFactory.quitDriver();
    }
}