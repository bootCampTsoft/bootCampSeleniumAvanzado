package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.base.botBase;

public class ppmSearchTimeSheets extends botBase {

    public ppmSearchTimeSheets(WebDriver driver) {
        super(driver);
    }
    By nombreRecurso = By.xpath("//tbody/tr[@id='search_table_row_0']/td[1]");
    By periodoTiempo = By.xpath("//tbody/tr[@id='search_table_row_0']/td[2]");
    By estado = By.xpath("//tbody/tr[@id='search_table_row_0']/td[4]");
    By tituloPagina = By.xpath("//td[@class='pagetitle-literule']");

    public String validarRecurso(){
        return getText(nombreRecurso);
    }
    public String periodoTiempo(){
        return getText(periodoTiempo);
    }
    public String estado(){
        return getText(estado);
    }
    public String tituloPagina(){
        return getText(tituloPagina);
    }
}
