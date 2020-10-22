package ea.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;

public class tc02_busquedaTest {

    WebDriver test;
    ppmLoginPage loginPage;
    ppmPageView pageview;

    @Before
    public void Setup() throws Exception{
        loginPage = new ppmLoginPage(test);
        pageview = new ppmPageView(test);
        loginPage.chromeDriverConnection();
        loginPage.visit("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        loginPage.login("eduardo.araya", loginPage.decodeString("QHRzZjE="));
    }

    @After
    public void closeTest() throws Exception{
        pageview.close();
    }

    @Test
    public void ConsultarUltimoParteDeHoras() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();

    }
}
