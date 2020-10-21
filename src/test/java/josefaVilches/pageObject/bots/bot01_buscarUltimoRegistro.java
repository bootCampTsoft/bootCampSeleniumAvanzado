package josefaVilches.pageObject.bots;

import jnr.ffi.annotations.In;
import josefaVilches.pageObject.base.Driver;
import josefaVilches.pageObject.pages.ppmFiltrosPartesPage;
import josefaVilches.pageObject.pages.ppmHomePage;
import josefaVilches.pageObject.pages.ppmLoginPage;
import josefaVilches.pageObject.pages.ppmResultadosPartesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bot01_buscarUltimoRegistro {
    WebDriver driver;

    @Before
    public void setUp() {
        Driver d = new Driver();
        driver = d.inicioChrome();
    }

    /**
     * Ingreso a la plataforma y obtengo el último parte con estado Closed
     */
    @Test
    public void obtenerUltimoRegistro() {
        ppmLoginPage loginPage = new ppmLoginPage(driver);
        ppmHomePage homePage = new ppmHomePage(driver);
        ppmFiltrosPartesPage filtrosPage = new ppmFiltrosPartesPage(driver);
        ppmResultadosPartesPage resultadosPage = new ppmResultadosPartesPage(driver);

        //Ingreso con mis datos
        loginPage.login("josefa.vilches","JV1lcH3e5");//usar decode

        //Ahora busco los partes de hora
        homePage.btnBuscar.click();
        homePage.dropDownParteHoras.click();

        //Filtro los partes
        filtrosPage.selectPeriodo.click();
        String nombre = filtrosPage.nombreRecurso.getText();
        //Me aseguro de que Recurso tenga mi nombre
        if (!nombre.contains("Josefa Vilches")) {
            filtrosPage.nombreRecurso.clear();
            filtrosPage.nombreRecurso.sendKeys("Josefa Vilches");
        }

        filtrosPage.radioSuspendidosCerradosSi.click();
        filtrosPage.btnBuscar.click();

        //Obtengo los resultados y los ordeno: de más reciente a menos reciente
        resultadosPage.headerPeriodo.click();
        resultadosPage.headerPeriodoClickeado.click();

        //Valido la fecha y el estado
        String textoFechaUltimoParte = resultadosPage.fecha.getAttribute("innerHTML").trim();
        String estadoUltimoParte = resultadosPage.estado.getText();
        String mes = textoFechaUltimoParte.substring(3,5);

        //Convierto mes a int
        int mesNum = Integer.parseInt(mes);

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("MM");
        String mesActual = formato.format(fechaActual);

        try {
            //Convierto mes actual a int
            int mesActualNum = Integer.parseInt(mesActual);

            //Comparo los meses
            if ((mesActualNum - mesNum) == 1) {
                //COnfirmo que el estado es CLosed
                if (estadoUltimoParte.contains("Closed")) {
                    System.out.println("Datos del parte más reciente: " + textoFechaUltimoParte + " " + estadoUltimoParte);
                    System.out.println("Mes Actual: " + mesActualNum + ", mes del parte: " + mesNum);
                    Assert.assertTrue(true);
                } else {
                    Assert.fail("El estado no es Closed");
                }
            } else {
                Assert.fail("No corresponde al mes anterior");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown(){
        driver.close();
    }


}
