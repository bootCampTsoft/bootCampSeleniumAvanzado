package pageObject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {

    protected WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver() {
        return driver;
    }
    public String getURL(){
        String url = driver.getCurrentUrl();
        return url;
    }
}
/*
* WebDriver driver;

//Inicialización del WebDriver con Chrome
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();


//Cargar la página
  driver.get("https://www.babytuto.com/");
*
*
*
* */