package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageObject.base.botBase;

/*
* URL: https://ppm.tsoftglobal.com/itg/dashboard/app/portal/PageView.jsp
* */

public class ppmHomePage extends botBase{
    public ppmHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@class='yuimenubaritemlabel yuimenubaritemlabel-hassubmenu yuimenubaritemlabel-selected yuimenubaritemlabel-hassubmenu-selected']")
    @CacheLookup
    public WebElement searchDropdown;
    @FindBy(xpath = "//a[@class='yuimenuitemlabel yuimenuitemlabel-selected']")
    @CacheLookup
    public WebElement timeSheet;



    public void goToSearchTimeSheets(){
        searchDropdown.click();
        timeSheet.click();
    }
    public void cerrarChrome(){
        driver.close();
    }

}
