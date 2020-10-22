package isaac.rodriguez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import isaac.rodriguez.base.BasePPM;

public class DatesPPMPage extends BasePPM {
    By conteinerFechas = By.xpath("//tr[@id='search_table_row_0']");
    By fecha = By.cssSelector(":nth-child(2)");

    public DatesPPMPage(WebDriver driver){
        super(driver);
    }

    public String ultimaFecha(){
        String ultimaFecha = getText(findElements(conteinerFechas).get(0).findElement(fecha)).split("-")[0];
        String fechaParseada = ultimaFecha.replace("/", "-").replace("20", "2020");
        return fechaParseada;
    }
}
