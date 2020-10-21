import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;

public class tc01_loginTest {

    WebDriver test;
    ppmLoginPage loginPage;
    ppmPageView pageview;

    @Before
    public void Setup() throws Exception{
        loginPage = new ppmLoginPage(test);
        pageview = new ppmPageView(test);
        loginPage.chromeDriverConnection();
        loginPage.visit("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
    }

    @After
    public void closeTest() throws Exception{
        loginPage.close();
    }

    @Test
    public void sesionDenegada() throws InterruptedException {
        loginPage.login("eduardo.araya", "1234");
        assertEquals("Nombre de usuario o contraseña no válido. Inicio de sesión denegado. (KNTA-10012)",loginPage.mensajeInicioSesionDenegado());
    }

    @Test
    public void sesionAceptada() throws InterruptedException{
        loginPage.login("eduardo.araya", loginPage.decodeString("QHRzZjE="));
    }



}
