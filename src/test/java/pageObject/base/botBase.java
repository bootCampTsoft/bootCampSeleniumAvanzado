package pageObject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {

    public WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void InicioChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }





}
