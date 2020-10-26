package ppm.registro_de_horas.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;
import pageObject.pages.ppmSearchTimeSheets;

import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;
import pageObject.pages.ppmSearchTimeSheets;

import static org.junit.Assert.*;

public class UnSoloParteDeHorasPorPeriodoDeTiempo {

    static WebDriver driver;
    static ppmLoginPage loginPage;
    static ppmPageView pageview;
    static ppmSearchTimeSheets searchTimeSheets;

    @Given("que el usuario no tiene partes de horas del período en que desea registrar sus horas")
    public void que_el_usuario_no_tiene_partes_de_horas_del_período_en_que_desea_registrar_sus_horas() throws InterruptedException {
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

        //periodo actual genera: 10/01/20 - 10/31/20
        periodo_actual = searchTimeSheets.getPeriodoActual();

        opcion_periodo_actual = searchTimeSheets.buscarPeriodoActual(periodo_actual);

        if (opcion_periodo_actual.equals(""))
        {
            System.out.println("Esta estoy habilitado");
        }
        else
        {
            System.out.println("No estoy habilitado");
        }

        assertEquals("",opcion_periodo_actual);
    }

    @When("el usuario intenta crear un parte de horas")
    public void el_usuario_intenta_crear_un_parte_de_horas() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("el sistema le permite crear la parte de horas deseada")
    public void el_sistema_le_permite_crear_la_parte_de_horas_deseada() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("que el usuario ya tiene una parte de horas en el período de tiempo deseado")
    public void que_el_usuario_ya_tiene_una_parte_de_horas_en_el_período_de_tiempo_deseado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("el usuario intenta crear una parte de horas en el mismo período de tiempo")
    public void el_usuario_intenta_crear_una_parte_de_horas_en_el_mismo_período_de_tiempo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("el sistema no le deja crear la parte de horas y le indica que ya existe dicha parte de horas")
    public void el_sistema_no_le_deja_crear_la_parte_de_horas_y_le_indica_que_ya_existe_dicha_parte_de_horas() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
