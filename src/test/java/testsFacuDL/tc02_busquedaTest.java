package testsFacuDL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;
import pageObject.pages.ppmTimeSheetsPage;

public class tc02_busquedaTest {

    WebDriver test;
    ppmLoginPage loginPage;
    ppmPageView pageview;
    ppmTimeSheetsPage timesheets;

    @Before
    public void Setup() throws Exception{
        loginPage = new ppmLoginPage(test);
        pageview = new ppmPageView(test);
        timesheets = new ppmTimeSheetsPage(test);
        loginPage.chromeDriverConnection();
        loginPage.visit("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        loginPage.login("eduardo.araya", loginPage.decodeString("QHRzZjE="));
    }

    @After
    public void closeTest() throws Exception{
        pageview.close();
    }

    @Test
    public void IrBuscarParteDeHoras() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        Assert.assertEquals("Buscar partes de horas", timesheets.tituloTimeSheets());
    }

    @Test
    public void nombreRecurso() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        Assert.assertEquals("Eduardo Andres Araya Ahumada", timesheets.validarRecurso());
    }


}
