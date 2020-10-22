package isaac.rodriguez.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePPM {
    private WebDriver driver;

    public BasePPM(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver conexionChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void type(String inputText, By identificador){
        driver.findElement(identificador).sendKeys(inputText);
    }

    public void click(By identificador){
        driver.findElement(identificador).click();
    }

    public void cargarPagina(String url){
        driver.get(url);
    }

    public void esperar(By indetificador){
        WebDriverWait esperaNotificacion = new WebDriverWait(driver, 10);
        esperaNotificacion.until(ExpectedConditions.visibilityOfElementLocated(indetificador));
    }

    public String getText(WebElement elemento){
        return elemento.getText();
    }

    public String getAttribute(By indentificador, String typeValue){
        return driver.findElement(indentificador).getAttribute(typeValue);
    }

    public Select select(By indentificador){
        WebElement element = driver.findElement(indentificador);
        Select select = new Select(element);
        return select;
    }

    public List<WebElement> findElements(By indentificador){
        return driver.findElements(indentificador);
    }
}
