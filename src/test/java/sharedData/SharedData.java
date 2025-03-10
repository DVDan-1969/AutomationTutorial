package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    //Aceasta clasa are ca rol sa deschida/inchida un browser.
    //Vom face acest lucru folosind adnotari de testNG.
    public WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");
        //initializeaza browser,deschide site,maximizeaza fereastra.

    }

    @AfterMethod
    public void cleareEnvironment(){
        driver.quit();//inchide browser.
    }
}
