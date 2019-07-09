package pages.shared;

import helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HeaderSection extends Element {

    public HeaderSection(Browser browser) {
        super(browser);
    }

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "submit")
    private WebElement clickLoginButton;

    @FindBy(className = "flash")
    private WebElement errorMsg;

    
    public void setUserName(String value) {
    	userNameInput.sendKeys(value);
    }
    
    public void setUserPassword(String value) {
    	passwordInput.sendKeys(value);
    }

    public void clickOnLoginButton() {
    	clickLoginButton.click();
    }
    
    public void assertErrorText() {
    	String msg = errorMsg.getText();
    	String errorMsg = " Your username is invalid!";
        Assert.assertEquals(msg, errorMsg);
    }

}
