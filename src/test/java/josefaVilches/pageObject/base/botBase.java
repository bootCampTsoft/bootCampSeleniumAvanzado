package josefaVilches.pageObject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {
    //Constructor Base
    public botBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
