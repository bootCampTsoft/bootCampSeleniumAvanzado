package isaac.rodriguez.bots;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import isaac.rodriguez.pages.DatesPPMPage;
import isaac.rodriguez.pages.FindHoursPPMPage;
import isaac.rodriguez.pages.LoginPPMPage;
import isaac.rodriguez.pages.UserHomePPMPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotPMMTest {
    private WebDriver driver;
    LoginPPMPage loginPPMPage;
    UserHomePPMPage userHomePPMPage;
    FindHoursPPMPage findHoursPPMPage;
    DatesPPMPage datesPPMPage;

    @Before
    public void setUp(){
        loginPPMPage = new LoginPPMPage(driver);
        driver = loginPPMPage.conexionChromeDriver();
        loginPPMPage.cargarPagina("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        userHomePPMPage = new UserHomePPMPage(driver);
        findHoursPPMPage = new FindHoursPPMPage(driver);
        datesPPMPage = new DatesPPMPage(driver);
    }

    @Test
    public void fechaTest() throws InterruptedException, ParseException {
        loginPPMPage.login("nombre.apellido", "password");
        userHomePPMPage.ingresarPartesHoras();
        findHoursPPMPage.buscarPartesHoras();

        SimpleDateFormat fechaformato = new SimpleDateFormat("MM-dd-yyyy");
        String ultimaFechaText = fechaformato.format(fechaformato.parse(datesPPMPage.ultimaFecha()));
        String fechaActualText = fechaformato.format(new Date());
        Date ultimaFecha = fechaformato.parse(ultimaFechaText);
        Date fechaActual = fechaformato.parse(fechaActualText);

        Assert.assertTrue(ultimaFecha.before(fechaActual));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
