package gabrielMarinan.pageObject.bots.ea;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import gabrielMarinan.pageObject.pages.ppmLoginPage;

public class bot01_buscarUltimoRegistro {

    WebDriver driver;
    ppmLoginPage loginPage = new ppmLoginPage(driver);

    @Test
    public void login(){
        loginPage.login("eduardo.araya","password");
    }
}
