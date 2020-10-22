package testsFacuDL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;
import pageObject.pages.ppmSearchTimeSheets;
import pageObject.pages.ppmTimeSheetsPage;

public class tc03_timeSheetBuscar {

    WebDriver test;
    ppmLoginPage loginPage;
    ppmPageView pageview;
    ppmTimeSheetsPage timesheets;
    ppmSearchTimeSheets searchTimeSheets;

    @Before
    public void Setup() throws Exception{
        loginPage = new ppmLoginPage(test);
        pageview = new ppmPageView(test);
        timesheets = new ppmTimeSheetsPage(test);
        searchTimeSheets = new ppmSearchTimeSheets(test);
        loginPage.chromeDriverConnection();
        loginPage.visit("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        loginPage.login("eduardo.araya", loginPage.decodeString("QHRzZjE="));
    }

    @After
    public void closeTest() throws Exception{
        searchTimeSheets.close();
    }

    @Test
    public void nombreRecurso() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        timesheets.buscarHoras();
        Assert.assertEquals("Eduardo Araya", searchTimeSheets.validarRecurso());
    }
    @Test
    public void periodoTiempo() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        timesheets.buscarHoras();
        Assert.assertEquals("1/09/20 - 30/09/20 - 1", searchTimeSheets.periodoTiempo());
    }
    @Test
    public void estado() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        timesheets.buscarHoras();
        Assert.assertEquals("Closed", searchTimeSheets.estado());
    }
    @Test
    public void paginaCorrecta() throws InterruptedException {
        pageview.IrBuscarParteDeHoras();
        timesheets.buscarHoras();
        Assert.assertEquals("Buscar partes de horas", searchTimeSheets.tituloPagina());
    }
}
