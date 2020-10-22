package isaac.rodriguez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import isaac.rodriguez.base.BasePPM;

public class FindHoursPPMPage extends BasePPM {
    By tiempoPeriodo = By.xpath("\t//input[@id='criteria(tsSearchByTimePeriod)_true']");
    By listaPeriodos = By.xpath("//select[@id='criteria(tsPeriodType)_id']");
    By recurso = By.xpath("//input[@id='tsResourceAC_TF']");
    By partesCerrados = By.xpath("//td[@class='field-label']//input[@id='tsIncludeClosedFrozen']");
    By btnBuscar = By.xpath("//div[contains(text(),'Buscar')]");
    public FindHoursPPMPage(WebDriver driver){
        super(driver);
    }

    public void buscarPartesHoras(){
        esperar(recurso);
        if (getAttribute(recurso, "value").equals("Isaac Rodriguez")){
            click(tiempoPeriodo);
            select(listaPeriodos).selectByVisibleText("Mensual");
            click(partesCerrados);
            click(btnBuscar);
        }
    }
}
