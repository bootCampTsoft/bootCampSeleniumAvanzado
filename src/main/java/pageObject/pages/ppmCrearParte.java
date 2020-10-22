package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.base.botBase;

public class ppmCrearParte extends botBase {


    public ppmCrearParte(WebDriver driver) {
        super(driver);
    }

    By titulo = By.xpath("//td[@class='pagetitle-heavyrule']");
    By mensajeErrorDoble = By.xpath("//div[@id='errorDuplicateTimeSheet']");
    By btnCrear = By.xpath("//div[contains(text(),'Crear')]");
    By recurso = By.xpath("//input[@id='resourceAC_TF']"); //getValue
    By descripcion = By.xpath("//input[@id='description']"); //getValue
    By tituloParteDeHoras = By.xpath("//div[@class='pagetitle']");
    By descripcionParteDeHoras = By.xpath("//input[@id='description']");
    By añadirElem = By.xpath("//span[@id='addWorkItems.label']");
    By añadirSolicitud = By.xpath("//div[@id='addWorkItems.REQUEST']");
    By buscarProyecto = By.xpath("//img[@id='P_41AUTOCOMP_IMG']");
    By proyectoTSOFT = By.xpath("//input[@id='P.CULL_TEXT']"); //sendKeys TSOFT
    By btnBuscar = By.xpath("//span[contains(text(),'Buscar')]"); // Mismo botón para ambos elementos
    By sitioUnoEquipo = By.xpath("//th[contains(text(),'TSOFT - SITIO UNO - Equipo')]");
    By seleccionarTodo = By.xpath("//input[@name='checkAll']");
    By btnAñadir = By.xpath("//div[@id='flatLinkView'] //a[@id='add.button']"); // Puede no funcionar
    By cantidadHoras = By.cssSelector("#REQUEST_117654_0"); //sendkeys cantHoras
    By btnGuardar = By.xpath("//a[@id='save_top']"); //botón guardar




}
