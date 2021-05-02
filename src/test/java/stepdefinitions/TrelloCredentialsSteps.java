package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class TrelloCredentialsSteps {

    private void pause(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ignore) {
            // do nothing
        }
    }

    @Given("^User goes to the signup page$")
    public void user_goes_to_the_signup_page() {
        WebElement signUpLink = Hooks.driver().findElement(By.linkText("Sign up"));
        signUpLink.click();
    }

    @Given("^user clicks on login link$")
    public void user_clicks_on_login_link() {
        WebElement loginLink = Hooks.driver().findElement(By.xpath("//span[@class='bottom-form-link']/a"));
        loginLink.click();
        pause(1);
    }

    @When("^user enters email and password for verified users$")
    public void user_enters_email_and_password_for_verified_users(DataTable table) {
        
        WebElement emailInput = Hooks.driver().findElement(By.id("user"));
        WebElement passInput = Hooks.driver().findElement(By.id("password"));
        
        List<List<String>> rows = table.asLists(String.class);

        // First user
        String firstUser = rows.get(0).get(0); 
        String firstPass = rows.get(0).get(1);
        emailInput.sendKeys(firstUser);
        passInput.sendKeys(firstPass);
        pause(1);
        emailInput.clear();
        passInput.clear();

        // Second user
        String secondUser = rows.get(1).get(0); 
        String secondPass = rows.get(1).get(1);
        emailInput.sendKeys(secondUser);
        passInput.sendKeys(secondPass);
        pause(1);
        emailInput.clear();
        passInput.clear();

        // Third user
        String thirdUser = rows.get(2).get(0); 
        String thirdPass = rows.get(2).get(1);
        emailInput.sendKeys(thirdUser);
        passInput.sendKeys(thirdPass);
        pause(1);
        emailInput.clear();
        passInput.clear();

    }

    @Then("^user should not see any error$")
    public void user_should_not_see_any_error() throws Throwable {
        WebElement hiddenErrorTextElem = Hooks.driver().findElement(By.cssSelector("div#error[class*='hidden']"));
        boolean isVisible = hiddenErrorTextElem.isDisplayed();
        Assert.assertFalse(isVisible);
    }
}
