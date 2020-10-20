package pageObject.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObject.base.botBase;


/*
 * URL: https://ppm.tsoftglobal.com/itg/tm/SearchTimeSheets.do
 * */
public class ppmSearchTimeSheets extends botBase {
    public ppmSearchTimeSheets(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='tsResourceAC_TF']")
    @CacheLookup
    public WebElement resourceNameInput;
    @FindBy(xpath = "//select[@id='criteria(tsPeriodType)_id']")
    @CacheLookup
    public Select periodTypeSelect;
    @FindBy(xpath = "//td[@class='field-label']")
    @CacheLookup
    public WebElement closedTimeSheetsYes;
    @FindBy(xpath = "//div[contains(text(),'Search')]")
    @CacheLookup
    public WebElement searchButton;
    @FindBy(css = "body.yui-skin-ppm:nth-child(2) div.page-min-width.ipad-page-min-height:nth-child(2) div.page-margins:nth-child(12) td:nth-child(1) table.gltable.search-results-panel tbody:nth-child(1) tr:nth-child(2) > td.slist-data-L:nth-child(5)")
    @CacheLookup
    public WebElement date;


}
