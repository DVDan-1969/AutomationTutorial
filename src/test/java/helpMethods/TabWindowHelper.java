package helpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabWindowHelper {
    public WebDriver driver;
// variabila WebDriver.
    public TabWindowHelper(WebDriver driver) {
        this.driver = driver;
    }
    //primeste o variabila din exterior de tipul driver si o salveaza in aceasta.

    public void switchToSpecificTabWindow(int index){
        List<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        //se muta cu focus pe un tab in fuctie de indexul pe care il dam.
    }

    public void closeCurrentTabWindow(){
       driver.close();
    }
    //inchide ferestrele
}
