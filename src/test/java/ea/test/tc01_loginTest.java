package ea.test;

import dataReader.DataReaderFactory;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.ppmLoginPage;
import pageObject.pages.ppmPageView;

import java.util.HashMap;
import java.util.List;

public class tc01_loginTest {

    WebDriver test;
    ppmLoginPage loginPage;
    ppmPageView pageview;
    String jsonFile ;
    String txtFile ;

    {
        jsonFile = "json/my_json.json";
        txtFile = "txt/my_txt.txt";
    }

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
    public void sesionDenegada() throws Throwable {

        List<HashMap<String, String>> data = DataReaderFactory.getReader("txt").readFile(txtFile);
        String user = data.get(0).get("user");
        String pass = data.get(0).get("pass");

        loginPage.login(user, pass);
        assertEquals("Nombre de usuario o contraseña no válido. Inicio de sesión denegado. (KNTA-10012)",loginPage.mensajeInicioSesionDenegado());
    }

    @Test
    public void sesionAceptada() throws InterruptedException{
        loginPage.login("eduardo.araya", loginPage.decodeString("QHyZjE="));
    }



}
