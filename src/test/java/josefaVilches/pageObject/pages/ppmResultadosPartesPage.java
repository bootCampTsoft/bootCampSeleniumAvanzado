package josefaVilches.pageObject.pages;

import josefaVilches.pageObject.base.botBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ppmResultadosPartesPage extends botBase {
    public ppmResultadosPartesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Definición de Objetos ppm Parte de Horas
    @FindBy(xpath = "//td[contains(text(), 'Periodo de tiempo: Parte de horas n°')]")
    @CacheLookup
    public WebElement headerPeriodo;

    @FindBy(xpath = "//span[contains(text(), 'Periodo de tiempo: Parte de horas n°')]")
    @CacheLookup
    //Despues del primer click
    public WebElement headerPeriodoClickeado;

    @FindBy(xpath = "//a[contains(text(), '01-09-20 - 30-09-20 - 1')]")
    @CacheLookup
    public WebElement fecha;

    @FindBy(xpath = "//td[contains(text(), 'Closed')]")
    @CacheLookup
    public WebElement estado;

    //Métodos
    public String retornarTituloPagina() { return driver.getTitle(); }


}
