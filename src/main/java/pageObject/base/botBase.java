package pageObject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class botBase {

    static public WebDriver driver;

    //Constructor Base
    public botBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //Envoltorios - Wrapper para Version de Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type (String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click (By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
       }
    }
    public void visit(String url){
        driver.get(url);
    }

    public void close(){
        driver.close();        
    }

    public String obtenerUrl(){
        return driver.getCurrentUrl();
    }

    //Conexiones
    public WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Metodos
    public String decodeString(String pass){
        byte[] decodedString = Base64.decodeBase64(pass);
        return (new String(decodedString));
    }

    public String encodeString(String pass){
        byte[] encodedString = Base64.encodeBase64(pass.getBytes());
        return (new String(encodedString));
    }





}
