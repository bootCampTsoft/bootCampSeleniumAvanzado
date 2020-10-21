package gabrielMarinan.pageObject.bots.gm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import gabrielMarinan.pageObject.pages.ppmHomePage;
import gabrielMarinan.pageObject.pages.ppmLoginPage;
import gabrielMarinan.pageObject.pages.ppmSearchTimeSheets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class bot01_buscarUltimoRegistro {


    WebDriver driver;
    ppmLoginPage loginPage;
    ppmHomePage homePage;
    ppmSearchTimeSheets searchTimeSheets;
    String user,pass;
    @BeforeClass
    public void credentials(){ // El BeforeClass sirve para obtener el password y el user de credentials.txt
        try {
            File myObj = new File("credentials.txt");
            Scanner myReader = new Scanner(myObj);
            user = myReader.nextLine();
            pass = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @BeforeTest
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");

    }
    @AfterClass
    public void finish(){
        driver.close();
    }
    @Test (priority = 0)
    public void login(){
        loginPage = new ppmLoginPage(driver);
        loginPage.login(user,pass);
        Assert.assertEquals("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp",loginPage.getURL());
        System.out.println("Login exitoso!");

    }
    @Test (priority = 1)
    public void goToSearchTimeSheets(){
        homePage = new ppmHomePage(driver);
        homePage.goToSearchTimeSheets();
        Assert.assertEquals("https://ppm.tsoftglobal.com/itg/tm/SearchTimeSheets.do",homePage.getURL());

    }
    @Test (priority = 2)
    public void realizarBusqueda(){
        searchTimeSheets = new ppmSearchTimeSheets(driver);
        searchTimeSheets.rellenarCampos();
        System.out.println("Campos rellenados");
        Assert.assertEquals(searchTimeSheets.getPeriodType(),"Monthly");
        Assert.assertEquals(searchTimeSheets.getResourceName(),"Gabriel Marinan");
        Assert.assertTrue(searchTimeSheets.closedTimeSheetsYes());
        System.out.println("Campos validados, se procede a buscar");
        searchTimeSheets.buscar();
    }
    @Test (priority = 3)
    public void esUltimoRegistro(){

    }
}
