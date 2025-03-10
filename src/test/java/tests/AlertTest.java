package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper=new ElementHelper(driver);

        AlertHelper alertHelper=new AlertHelper(driver);

        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertFrameWindowsMenu);

        By alertsSubmenu = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJSLocator(alertsSubmenu);

        By alert0kElement = By.id("alertButton");
        elementHelper.clickLocator(alert0kElement);

      //  Alert alert0k = driver.switchTo().alert();
       // System.out.println(alert0k.getText());//da textul care este scris pe alerta
        //alert0k.accept();
        alertHelper.acceptAlert();

        By timerAlertElement = By.id("timerAlertButton");
      elementHelper.clickLocator(timerAlertElement);
      alertHelper.acceptAlert();


        By cofirmElement = By.id("confirmButton");
       elementHelper.clickLocator(cofirmElement);

     //   Alert alert0kCancel = driver.switchTo().alert();
     //   System.out.println(alert0kCancel.getText());
     //   alert0kCancel.dismiss();
        alertHelper.cancelAlert();

        By promtElement = By.id("promtButton");
       elementHelper.clickLocator(promtElement);

     //   Alert alertPromt= driver.switchTo().alert();
     //   System.out.println(alertPromt.getText());
      //  String alertValue ="Life is good";
     //   alertPromt.sendKeys(alertValue);
      //  alertPromt.accept();
        alertHelper.fillAlert("Altceva");
    }
}
