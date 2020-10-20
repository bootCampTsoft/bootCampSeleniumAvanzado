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
        driver.get(driver.getCurrentUrl());
    }


    @FindBy(css = "body.yui-skin-ppm:nth-child(2) div.page-min-width.ipad-page-min-height:nth-child(2) div.yui-b:nth-child(2) div.yui-gc div.yui-u.first:nth-child(1) div.yuimenubar.yuimenubarnav.yui-module.yui-overlay.visible div.bd ul.first-of-type li.yuimenubaritem.yuimenubaritem-hassubmenu.menushown.yuimenubaritem-selected.yuimenubaritem-hassubmenu-selected:nth-child(3) > a.yuimenubaritemlabel.yuimenubaritemlabel-hassubmenu.yuimenubaritemlabel-selected.yuimenubaritemlabel-hassubmenu-selected")
    public WebElement searchDropdown;
    @FindBy(xpath = "//a[@class='yuimenuitemlabel yuimenuitemlabel-selected']")
    public WebElement timeSheet;
    @FindBy(xpath = "//img[@style='margin-left:5px;']")
    public WebElement image;



    public void goToSearchTimeSheets(){
        searchDropdown.click();
        timeSheet.click();
    }

}
