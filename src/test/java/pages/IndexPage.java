package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage{

private WebDriver driver;
    private ElementHelper elementHelper;



    public IndexPage(WebDriver driver) {
        this.driver=driver;
        elementHelper=new ElementHelper(driver);


    }

    public void enterOnAlertFrameWindowMenu() {
        elementHelper.clickJSLocator(IndexLocators.alertFrameWindowsMenu);
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertSubMenu);
    }
    public void enterOnBrowserWindowsSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.browserWindowsSubMenu);

    }
    public void enterOnFrameSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
    }

}
