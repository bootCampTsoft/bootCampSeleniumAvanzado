package josefaVilches.pageObject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {
    WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
