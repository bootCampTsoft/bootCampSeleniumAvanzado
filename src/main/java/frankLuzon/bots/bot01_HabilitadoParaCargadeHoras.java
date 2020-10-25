package frankLuzon.bots;

import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;
import pageObject.pages.ppmSearchTimeSheets;

public class bot01_HabilitadoParaCargadeHoras {

    static WebDriver driver;
    static ppmLoginPage loginPage;
    static ppmPageView pageview;
    static ppmSearchTimeSheets searchTimeSheets;

    public static void main(String[] args) throws InterruptedException
    {
        String periodo_actual;
        String opcion_periodo_actual;

        loginPage = new ppmLoginPage(driver);
        pageview = new ppmPageView(driver);
        searchTimeSheets = new ppmSearchTimeSheets(driver);
        loginPage.chromeDriverConnection();
        loginPage.visit("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        loginPage.login("frank.luzon", loginPage.decodeString("TXZlQzIwMjBlbSE="));
        pageview.IrBuscarParteDeHoras();
        searchTimeSheets.seleccionarPeriodoMensual();
        Thread.sleep(2000);

        periodo_actual = searchTimeSheets.getPeriodoActual();
        opcion_periodo_actual = searchTimeSheets.buscarPeriodoActual(periodo_actual);

        if (opcion_periodo_actual.equals(""))
        {
            System.out.println("No estoy habilitado");
        }
        else
        {
            System.out.println("Estoy habilitado");
        }

    }

}
