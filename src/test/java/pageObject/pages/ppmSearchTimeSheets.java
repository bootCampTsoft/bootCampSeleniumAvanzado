package pageObject.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObject.base.botBase;


/*
 * URL: https://ppm.tsoftglobal.com/itg/tm/SearchTimeSheets.do
 * */
public class ppmSearchTimeSheets extends botBase {
    public ppmSearchTimeSheets(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='tsResourceAC_TF']")
    public WebElement resourceNameInput;
    @FindBy(xpath = "//select[@id='criteria(tsPeriodType)_id']")
    public WebElement periodTypeSelect;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
    public WebElement closedTimeSheetsYes;
    @FindBy(xpath = "//div[contains(text(),'Search')]")
    public WebElement searchButton;
    @FindBy(xpath = "//div[contains(text(),'Buscar')]")
    public WebElement date;

    public void rellenarCampos(){
        espera.until(ExpectedConditions.elementToBeClickable(closedTimeSheetsYes));
        closedTimeSheetsYes.click();
        Select periodTypeSelect1 = new Select(periodTypeSelect);
        periodTypeSelect1.selectByValue("4");

        searchButton.click();
    }
    public String getResourceName(){
        return resourceNameInput.getText();
    }


}
