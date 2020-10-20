package bots.ea;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObject.pages.ppmLoginPage;

public class bot01_buscarUltimoRegistro {

    WebDriver driver;
    ppmLoginPage loginPage = new ppmLoginPage(driver);

    @Test
    public void login(){
        loginPage.InicioChrome();
        loginPage.cargarPpmLoginPage();
        loginPage.login("eduardo.araya","password");
    }
}
