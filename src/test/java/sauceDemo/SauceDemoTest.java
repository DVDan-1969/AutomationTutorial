package sauceDemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceDemoTest {
    @Test

    public void sauceDemoTest(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("https:soucedemo.com");
        driver.manage().window().maximize();
    }
}
