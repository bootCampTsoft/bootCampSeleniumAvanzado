package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageObject.base.botBase;

/*
 * URL: https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp
 * */
public class ppmLoginPage extends botBase {

    public ppmLoginPage(WebDriver driver) {
        super(driver);
    }

    //Definicion de Objetos ppmLogin Page
    By username = By.xpath("//input[@id='field-username']");
    By password = By.xpath("//input[@id='field-password']");
    By btnIniciarSesion = By.xpath("//div[@id='label-LOGON_SUBMIT_BUTTON_CAPTION']");
    By message = By.xpath("//div[@id='message']");


    //Metodos para Login Page
    public void login(String user, String pass) throws InterruptedException {
        Thread.sleep(3000);
        if(isDisplayed(username)){
            type(user,username);
            type(pass,password);
            click(btnIniciarSesion);
        }else{
            System.out.println("la url no se cargo correctamente. error tiempo de carga > 3000 ms");
        }
    }

    public String mensajeInicioSesionDenegado(){
        return getText(message);

    }


}
