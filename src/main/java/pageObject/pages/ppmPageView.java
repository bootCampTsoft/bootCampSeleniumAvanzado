package pageObject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.base.botBase;

/*
 * URL: https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp
 * */
public class ppmPageView extends botBase {

    //Definicion de Objetos ppmPageView
    By buscar = By.xpath("//a[contains(text(),'Buscar')]");
    By partesDeHoras = By.xpath("//a[contains(text(),'Partes de horas')]");
    By linkCerrarSesion = By.xpath("//a[contains(text(),'Cerrar sesión')]");
    By btnCrear = By.xpath("//a[contains(text(),'Crear')]");
    By parteHoras = By.xpath("//a[contains(text(),'Parte de horas')]");
    //objetos Busqueda Partes Horas


    public ppmPageView(WebDriver driver) {
        super(driver);
    }


    //Definicion de Metodos para PageView
    public void IrBuscarParteDeHoras() throws InterruptedException {
        click(buscar);
        Thread.sleep(4000);
        click(partesDeHoras);
        Thread.sleep(4000);
        System.out.println("Mostrando página de parte de horas");
    }

    public void CrearParteHoras() throws InterruptedException {
        click(btnCrear);
        Thread.sleep(1111);
        click(parteHoras);
    }
}
