package josefaVilches.pageObject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public WebDriver inicioChrome() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
}
