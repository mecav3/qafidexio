package org.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Login_page;
import org.util.ConfigurationReader;
import org.util.Driver;

import java.io.File;
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

        takeSnapShot( "target/validate_image.png");

          Assert.assertEquals("Please fill out this field.",
             Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage"));

    }

    public static void takeSnapShot(String fileWithPath) throws Exception {
        File SrcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        button_login.click();
    }
}

