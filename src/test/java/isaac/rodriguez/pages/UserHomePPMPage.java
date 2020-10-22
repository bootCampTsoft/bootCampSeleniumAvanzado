package isaac.rodriguez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import isaac.rodriguez.base.BasePPM;

public class UserHomePPMPage extends BasePPM {
    By listaBuscar = By.xpath("//a[contains(text(),'Buscar')]");
    By itemPartesHoras = By.xpath("//a[contains(text(),'Partes de horas')]");

    public UserHomePPMPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarPartesHoras() {
        esperar(listaBuscar);
        click(listaBuscar);
        click(itemPartesHoras);
    }
}
