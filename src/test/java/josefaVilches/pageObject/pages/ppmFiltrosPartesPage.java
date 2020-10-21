package josefaVilches.pageObject.pages;

import josefaVilches.pageObject.base.botBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ppmFiltrosPartesPage extends botBase {
    public ppmFiltrosPartesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//option[contains(text(),'Mensual')]" )
    @CacheLookup
    public WebElement selectPeriodo;

    @FindBy(xpath = "//input[@id='tsResourceAC_TF']")
    @CacheLookup
    public WebElement nombreRecurso;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
    @CacheLookup
    public WebElement radioSuspendidosCerradosSi;

    @FindBy(xpath = "//div[contains(text(),'Buscar')]")
    @CacheLookup
    public WebElement btnBuscar;
}
