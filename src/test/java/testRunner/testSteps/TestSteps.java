package testRunner.testSteps;

import static org.junit.Assert.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class TestSteps {

    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    LoginPage loginpage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("A user is on the login page")
    public void a_user_is_on_the_main_page() {
        driver.get(baseURL);
    }

    @When("A user enters {}, {} for login")
    public void user_enters_data_for_login(String username, String password) throws InterruptedException {
        driver.get(baseURL);

        loginpage = new LoginPage(driver);
        loginpage.loginUser(username, password);
    }

    @Then("A user successfully logged in as {}, {}")
    public void user_is_logged_in(String username, String password) throws InterruptedException {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("The user is not authorised as {}, {} because the password is incorrect")
    public void password_incorrect(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginpage.getErrorMessage()));
        assertTrue(loginpage.getErrorMessage().isDisplayed());
    }
}
