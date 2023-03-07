import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
