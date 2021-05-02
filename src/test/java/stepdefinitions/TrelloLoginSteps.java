package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.github.javafaker.Faker;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrelloLoginSteps {

    // ------ Fields
    private WebDriver driver;

    private void pause(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ignore) {
            // do nothing
        }
    }

    @Given("^User goes to the Trello homepage$")
    public void user_goes_to_the_Trello_homepage() {
        Hooks.driver().get("https://trello.com");
    }

    @Given("^User clicks on login link$")
    public void user_clicks_on_login_link() {
        By loc_login_link = By.linkText("Log in");
        WebElement loginLinkElem = Hooks.driver().findElement(loc_login_link);
        loginLinkElem.click();
    }

    @When("^User is on login page$")
    public void user_is_on_login_page() {
        By loc_page_banner = By.xpath("//h1[text()='Log in to Trello']");
        WebElement pageBannerElem = Hooks.driver().findElement(loc_page_banner);
        boolean isVisible = pageBannerElem.isDisplayed();
        Assert.assertTrue(isVisible);
    }

    @When("^User logs in with valid credentials$")
    public void user_logs_in_with_valid_credentials() {
        By loc_email = By.id("user");
        By loc_pass = By.id("password");
        By loc_log_bttn = By.id("login");
        WebElement emailInput = Hooks.driver().findElement(loc_email);
        WebElement passInput = Hooks.driver().findElement(loc_pass);
        WebElement loginBttn = Hooks.driver().findElement(loc_log_bttn);
        loginBttn.click();
    }

    @Then("^User should be able to see Trello boards page$")
    public void user_should_be_able_to_see_Trello_boards_page() {
        pause(3);
        By loc_page_banner = By.xpath("//h3[text()='Trello workspace']");
        WebElement pageBanner = Hooks.driver().findElement(loc_page_banner);
        boolean isVisible = pageBanner.isDisplayed();
        Assert.assertTrue(isVisible);
    }

    @When("^User logs in with invalid credentials$")
    public void user_logs_in_with_invalid_credentials() {
        By loc_email = By.id("user");
        By loc_pass = By.id("password");
        By loc_log_bttn = By.id("login");
        WebElement emailInput = Hooks.driver().findElement(loc_email);
        WebElement passInput = Hooks.driver().findElement(loc_pass);
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePass = faker.internet().password();
        emailInput.sendKeys((fakeEmail));
        passInput.sendKeys(fakePass);
        WebElement loginBttn = Hooks.driver().findElement(loc_log_bttn);
        loginBttn.click();
    }

    @Then("^User should be able to see an error message$")
    public void user_should_be_able_to_see_an_error_message() {
        pause(3);
        By loc_error_msg = By.xpath("//div[@id='error']/p");
        WebElement errorMsgElement = Hooks.driver().findElement(loc_error_msg);
        String actualErrorMessage= errorMsgElement.getText();
        Assert.assertEquals("There isn't an account for this email", actualErrorMessage);
    }
}
