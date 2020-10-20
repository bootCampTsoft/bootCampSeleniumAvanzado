package pageObject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class botBase {

    protected WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver){
        this.driver = driver;


    }
    public void inicializarChrome(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        PageFactory.initElements(this.driver,this);
    }
    public void cargarPagina(String url){
        inicializarChrome();
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
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