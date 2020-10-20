package bots.ea;

import org.junit.Before;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.pages.ppmHomePage;
import pageObject.pages.ppmLoginPage;

public class bot01_buscarUltimoRegistro {


    WebDriver driver;
    ppmLoginPage loginPage = new ppmLoginPage(driver);




    @Test
    public void login(){
        loginPage.cargarPagina("https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp");
        loginPage.login("gabriel.marinan","GM4r1n4N");
        driver = loginPage.getDriver();
        ppmHomePage homePage = new ppmHomePage(driver);
        homePage.goToSearchTimeSheets();
    }
}
