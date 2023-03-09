package org.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Login_page;
import org.util.ConfigurationReader;
import org.util.Driver;

import java.time.Duration;

public class LoginStepDefs extends Login_page {

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        Driver.getDriver().get(
                ConfigurationReader.getProperty("url")
        );
    }

    @When("enters username")
    public void entersUsername() {
        input_user.sendKeys(ConfigurationReader.getProperty("username"));

    }

    @Then("enters password")
    public void entersPassword() {
        input_password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        button_login.click();
    }

    @Then("user logged in")
    public void userLoggedIn() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logged_username));

        Assert.assertTrue(logged_username.isDisplayed());
    }

    @When("enters wrong username")
    public void entersWrongUsername() {
        input_user.sendKeys("someuser");
    }

    @Then("enters wrong password")
    public void entersWrongPassword() {
        input_password.sendKeys("somepassword");
    }

    @Then("user cannot login warning")
    public void userCannotLoginWarning() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(wrong_login_warning));

        Assert.assertTrue(wrong_login_warning.isDisplayed());

    }

    @Then("user get empty field warning")
    public void userGetEmptyFieldWarning() {

        Assert.assertEquals("Please fill out this field.",
                Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage"));


    }


}
