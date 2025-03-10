package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;



public class FrameTest extends SharedData {


    @Test
    public void metodaTest() {
        ElementHelper elementHelper=new ElementHelper(driver);
        PageHelper pageHelper=new PageHelper(driver);



        By frameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(frameWindowsMenu);

        By framesSubmenu=By.xpath("//span[text()='Frames']");
        elementHelper.clickJSLocator(framesSubmenu);

        driver.switchTo().frame("frame1");
        WebElement textElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement.getText());

        driver.switchTo().parentFrame();//te intorci cu focus pe pagina parinte

        driver.switchTo().frame("frame2");
        WebElement textElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(textElement2.getText());

    }
}
