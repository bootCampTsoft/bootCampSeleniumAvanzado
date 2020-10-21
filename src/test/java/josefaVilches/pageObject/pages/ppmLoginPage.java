package josefaVilches.pageObject.pages;

import josefaVilches.pageObject.base.botBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ppmLoginPage extends botBase {

    public ppmLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Definicion de Objetos ppmLogin Page
    @FindBy(xpath ="//input[@id='field-username']")
    @CacheLookup
    public WebElement username;

    @FindBy(xpath ="//input[@id='field-password']")
    @CacheLookup
    public WebElement password;

    @FindBy(xpath ="//div[@id='label-LOGON_SUBMIT_BUTTON_CAPTION']")
    @CacheLookup
    public WebElement btnIniciarSesion;

    //Métodos genéricos
    public void login(String user, String pass) {
        abrirURL("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        username.sendKeys(user);
        password.sendKeys(pass);
        btnIniciarSesion.click();
    }
}
