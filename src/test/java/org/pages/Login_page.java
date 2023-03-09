package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.Driver;

public class Login_page {
    public Login_page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#login")
    public WebElement input_user;

    @FindBy(css = "input#password")
    public WebElement input_password;

    @FindBy(css = "button.btn.btn-primary")
    public WebElement button_login;

    @FindBy(css = "span.oe_topbar_name")
    public WebElement logged_username;

    @FindBy(css = "p.alert.alert-danger")
    public WebElement wrong_login_warning;


}
