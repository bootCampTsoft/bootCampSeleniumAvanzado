package bots.ea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.pages.ppmHomePage;
import pageObject.pages.ppmLoginPage;

import java.util.concurrent.TimeUnit;

public class bot01_buscarUltimoRegistro {


    WebDriver driver;
    ppmLoginPage loginPage;
    ppmHomePage homePage;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
    }




    @Test(priority = 0)
    public void login(){
        loginPage = new ppmLoginPage(driver);
        loginPage.login("gabriel.marinan","GM4r1n4N");

    }
    @Test(priority = 1)
    public void goToSearchTimeSheets(){
        homePage = new ppmHomePage(driver);
        homePage.goToSearchTimeSheets();
    }
}
