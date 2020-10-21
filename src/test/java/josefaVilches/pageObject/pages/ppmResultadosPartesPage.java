package josefaVilches.pageObject.pages;

import josefaVilches.pageObject.base.botBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ppmResultadosPartesPage extends botBase {
    public ppmResultadosPartesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
