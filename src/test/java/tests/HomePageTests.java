package tests;

import helper.Browser;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import helper.TestHelper;

public class HomePageTests extends TestHelper {

    Browser browser;

    @Parameters({"browserName", "baseUrl"})
    @BeforeClass(groups = {"web"})
    public void setUp(String browserName, String baseUrl) {
        browser = new Browser(browserName, baseUrl);
        browser.navigateToBaseUrl();
    }

    /* Validate Page Title */
    @Test(groups = {"web"})
    public void validatePageTitle() throws InterruptedException {
    	String actualTitle = "The Internet";
    	 Assert.assertEquals(((WebDriver) browser).getTitle(), actualTitle);
    }
    
    /* Validate User name and Password Inputs */
    @Test(groups = {"web"})
    public void landOnLoginPage() throws InterruptedException {
    String actualTitle = "Login Page";
   	 Assert.assertEquals(((WebDriver) browser).getTitle(), actualTitle);
   	browser.HomePage().HeaderSection().setUserName("tomsmith");
   	browser.HomePage().HeaderSection().setUserPassword("SuperSecretPassword!");
   	browser.HomePage().HeaderSection().clickOnLoginButton();
    }
    
    /* Validate Error Message Use Case */
    @Test(groups = {"web"})
    public void validateErrorMsg() throws InterruptedException {
   	browser.HomePage().HeaderSection().setUserName("tomsmith1");
   	browser.HomePage().HeaderSection().setUserPassword("SuperSecretPassword!1");
   	browser.HomePage().HeaderSection().clickOnLoginButton();
   	browser.HomePage().HeaderSection().assertErrorText();
    }

    @AfterClass(groups = {"web"})
    public void tearDown() {
        browser._driver.quit();
    }

}
