package org.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Login_page;
import org.util.ConfigurationReader;
import org.util.Driver;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class LoginStepDefs extends Login_page {

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("enters username")
    public void entersUsername() {
        input_user.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @Then("enters password")
    public void entersPassword() {
        input_password.sendKeys(ConfigurationReader.getProperty("password"));
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
    public void userGetEmptyFieldWarning() throws Exception {
        Driver.takeSnapShot("target/validate_image.png");
        Assert.assertEquals("Please fill out this field.",
                input_password.getAttribute("validationMessage"));
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        button_login.click();
    }

    @Then("check password is hidden")
    public void checkPasswordIsHidden() throws Exception {

        System.out.println("required user : " + input_user.getAttribute("required"));
        System.out.println("validation user : " + input_user.getAttribute("validationMessage"));

        System.out.println("required pass : " + input_password.getAttribute("required"));
        System.out.println("validation pass : " + input_password.getAttribute("validationMessage"));

        System.out.println("get value entered = " + input_password.getAttribute("value"));
        Driver.takeSnapShot("target/password_hidden.png");

        if (input_password.getAttribute("type").equals("password"))
            System.out.println("it should be MASKED on default by browser");
    }

    @And("hits enter button")
    public void hitsEnterButton() {
        input_password.sendKeys(Keys.ENTER);
    }
}

