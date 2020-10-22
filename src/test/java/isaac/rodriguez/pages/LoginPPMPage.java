package isaac.rodriguez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import isaac.rodriguez.base.BasePPM;

public class LoginPPMPage extends BasePPM {
    By username = By.xpath("//input[@id='field-username']");
    By password = By.xpath("//input[@id='field-password']");
    By btnInicarSesion = By.xpath("//div[@id='label-LOGON_SUBMIT_BUTTON_CAPTION']");

    public LoginPPMPage(WebDriver driver){
        super(driver);
    }

    public void login(String user, String pass){
        type(user, username);
        type(pass, password);
        click(btnInicarSesion);
    }
}
