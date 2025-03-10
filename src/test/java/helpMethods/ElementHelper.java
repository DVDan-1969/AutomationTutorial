package helpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    //wait general
    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//obiectul de Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickLocator() {
    }
    //metoda face click pe un element
    public void clickLocator(By locator) {
        waitForElementVisible(locator);//asteapta dupa element inainte de a da click
        driver.findElement(locator).click();// da click pe element pe element,il transformam din By in element apoi clk.
    }
    public void clickJSLocator(By locator) {
        waitForElementVisible(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",driver.findElement(locator));

    }
    public void fillLocator(By locator,String value){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void fillPressLocator(By locator, String value, Keys key){
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);

    }
}
