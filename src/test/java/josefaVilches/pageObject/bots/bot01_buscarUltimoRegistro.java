package josefaVilches.pageObject.bots;

import josefaVilches.pageObject.base.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class bot01_buscarUltimoRegistro {



    WebDriver driver;
    ppmLoginPage loginPage = new ppmLoginPage(driver);

    @Before
    public void setUp() {
        Driver d = new Driver();
        driver = d.inicioChrome();
    }

    @Test
    public void login() {

    }


}
