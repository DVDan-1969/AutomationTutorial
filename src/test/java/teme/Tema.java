package teme;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tema{



    public WebDriver driver;


    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://emag.ro/webtables");
    }
}



