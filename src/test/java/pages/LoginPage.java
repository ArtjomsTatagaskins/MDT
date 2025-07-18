package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(id="user-name") // id locator
    WebElement usernameInput;

    @FindBy(xpath="//input[@id='password']") // xpath locator
    WebElement passwordInput;

    @FindBy(className="btn_action") // class locator
    WebElement loginButton;

    @FindBy(css=".error-message-container.error") // cssSelector
    WebElement errorMessage;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
