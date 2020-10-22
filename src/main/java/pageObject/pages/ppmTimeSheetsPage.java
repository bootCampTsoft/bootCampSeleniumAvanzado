package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObject.base.botBase;

public class ppmTimeSheetsPage extends botBase{

    public ppmTimeSheetsPage(WebDriver driver) {
        super(driver);
    }

    By nombreRecurso = By.xpath("//input[@id='tsResourceAC_TF']");
    By selectPeriodo = By.xpath("//select[@id='criteria(tsPeriodType)_id']");
    By selectMensual = By.xpath("//option[contains(text(),'Mensual')]");
    By parteHorasCerrado = By.cssSelector("#tsIncludeClosedFrozen");
    By btnBuscar = By.xpath("//div[contains(text(),'Buscar')]");


    public void buscarHoras() throws InterruptedException {
        click(selectPeriodo);
        Thread.sleep(1111);
        click(selectMensual);
        click(parteHorasCerrado);
        click(btnBuscar);
        System.out.println("Se ha ingresado al parte de horas total");
    }

    public String tituloTimeSheets(){
        return getTitle();
    }

    public String validarRecurso(){
        return getValue(nombreRecurso);
    }
}
