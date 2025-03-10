package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest extends SharedData {

    @Test
    public void metodaTest() {

        TabWindowHelper tabWindowHelper=new TabWindowHelper(driver);
        //obiect instantiat cu new.
        ElementHelper elementHelper=new ElementHelper(driver);

        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertFrameWindowsMenu);

        By browserWindowsSubmenu = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickLocator(browserWindowsSubmenu);

        By newTabElement= By.id("tabButton");
      elementHelper.clickLocator(newTabElement);

        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.switchToSpecificTabWindow(1);
        //se apeleaza obiectul si se da index 1 si in loc sa scriem aceeasi actiune de mai multe ori facem un constructor
        // si il apelam.


        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.closeCurrentTabWindow();

        tabWindowHelper.switchToSpecificTabWindow(0);

        By newWindowElement=By.id("windowButton");
        elementHelper.clickLocator(newWindowElement);

       tabWindowHelper.switchToSpecificTabWindow(1);
        System.out.println(driver.getCurrentUrl());

    }
}
