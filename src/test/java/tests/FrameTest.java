package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.FramePage;
import pages.IndexPage;
import sharedData.SharedData;



public class FrameTest extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage=new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnFrameSubMenu();

        FramePage framePage=new FramePage(driver);
        framePage.switchToSpecificTab();
        framePage.switchToParent();




    }
}
