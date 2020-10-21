package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.base.botBase;

/*
* URL: https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp
* */

public class ppmHomePage extends botBase{
    public ppmHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(text(),'Search')]")
    public WebElement searchDropdown;
    @FindBy(xpath = "//a[contains(text(),'Time Sheets')]")
    public WebElement timeSheet;



    public void goToSearchTimeSheets(){
        searchDropdown.click();
        espera.until(ExpectedConditions.elementToBeClickable(timeSheet));
        timeSheet.click();
    }

}
