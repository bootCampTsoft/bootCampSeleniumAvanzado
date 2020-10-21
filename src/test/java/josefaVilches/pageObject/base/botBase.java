package josefaVilches.pageObject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {
    public WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver) {
        this.driver = driver;
    }

    //Meétodo genérico
    public String abrirURL(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }
}
