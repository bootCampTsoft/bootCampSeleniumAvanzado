package josefaVilches.pageObject.bots;

import josefaVilches.pageObject.base.Driver;
import josefaVilches.pageObject.pages.ppmFiltrosPartesPage;
import josefaVilches.pageObject.pages.ppmHomePage;
import josefaVilches.pageObject.pages.ppmLoginPage;
import josefaVilches.pageObject.pages.ppmResultadosPartesPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class bot01_buscarUltimoRegistro {

    WebDriver driver;

    @Before
    public void setUp() {
        Driver d = new Driver();
        driver = d.inicioChrome();
    }

    @Test
    public void login() {
        ppmLoginPage loginPage = new ppmLoginPage(driver);
        ppmHomePage homePage = new ppmHomePage(driver);
        ppmFiltrosPartesPage filtrosPage = new ppmFiltrosPartesPage(driver);
        ppmResultadosPartesPage resultadosPage = new ppmResultadosPartesPage(driver);

        loginPage.login("josefa.vilches","JV1lcH3e5"); //usar decode

    }


}
