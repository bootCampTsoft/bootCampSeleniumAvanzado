package josefaVilches.pageObject.pages;

import josefaVilches.pageObject.base.botBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ppmHomePage extends botBase {

    public ppmHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Buscar')]")
    @CacheLookup
    public WebElement btnBuscar;

    @FindBy(xpath = "//a[contains(text(),'Partes de horas')]")
    @CacheLookup
    public WebElement dropDownParteHoras;
}
