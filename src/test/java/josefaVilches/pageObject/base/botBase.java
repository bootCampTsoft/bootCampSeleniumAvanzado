package josefaVilches.pageObject.base;

import org.apache.commons.codec.binary.Base64;
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

    public String decodeString(String pass){
        byte[] decodedString = Base64.decodeBase64(pass);
        return (new String(decodedString));
    }
}
