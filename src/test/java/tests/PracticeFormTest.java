package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper=new ElementHelper(driver);

        PageHelper pageHelper=new PageHelper(driver);



        By formsMenu =By.xpath("//h5[text()='Forms']");
       elementHelper.clickJSLocator(formsMenu);

        By practiceFormSubMenu = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSLocator(practiceFormSubMenu);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Dan";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Dudas";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "dvdudas@yahoo.com";
        elementHelper.fillLocator(emailElement,emailValue);


        String genderValue = "Male";
        By genderOptionsElement = By.xpath("//input[@name='gender']");
        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
        if (genderValue.equals("Male")) {

            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")) {
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Other")) {
            elementHelper.clickJSLocator(genderOptionsList.get(2));
        }
        By mobilePhoneElement = By.xpath("//input[@placeholder='Mobile Number']");
        String mobilPhoneValue = "0771073248";
        elementHelper.fillLocator(mobilePhoneElement,mobilPhoneValue);
        pageHelper.scrollByPixel(0,500);

        pageHelper.scrollByPixel(0,500);

        By subjectsElement = By.id("subjectsInput");
        elementHelper.clickJSLocator(subjectsElement);

        //lista de string.
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        subjects.add("Chemistry");

        for (int index = 0; index < subjects.size(); index++) {


         elementHelper.fillPressLocator(subjectsElement,subjects.get(index),Keys.ENTER);
        }
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        hobbies.add("Reading");

        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbies.contains(currentText)){
             elementHelper.clickJSLocator(hobbiesOptionsList.get(index));
            }
        }
        By pictureElement = By.id("uploadPicture");
        File file = new File("src/test/resources/8ek76goi.png");
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By currentAddressElement= By.id("currentAddress");
        String currentAddressValue="Timisoara";
       elementHelper.fillLocator(currentAddressElement,currentAddressValue);

        By stateElement =By.xpath("//div[text()='Select State']");
        elementHelper.clickJSLocator(stateElement);

        By stateInputElement = By.id("react-select-3-input");
        String stateInputValue = "NCR";
       elementHelper.fillPressLocator(stateInputElement,stateInputValue,Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

        By cityInputElement = By.id("react-select-4-input");
        String cityInputValue="Delhi";
        elementHelper.fillPressLocator(cityInputElement,cityInputValue,Keys.ENTER);

        By submitElement = By.id("submit");
        elementHelper.clickJSLocator(submitElement);
        //Validari

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        WebElement thankYouElement= driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage="Thanks for submitting the form";
        String actualMessage =thankYouElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
      System.out.println("Testul a fost validat");


        By tablesRowsListElement=By.xpath("//tbody/tr");
        List<WebElement> tablesRowsList=driver.findElements(tablesRowsListElement);
        elementHelper.validateTextContainsElement(tablesRowsList.get(0),"Student Name");
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), lastNameValue);


     elementHelper.validateTextContainsElement(tablesRowsList.get(1),"Student Email");
     elementHelper.validateTextContainsElement(tablesRowsList.get(1),emailValue);

     elementHelper.validateTextContainsElement(tablesRowsList.get(2),"Gender");
     elementHelper.validateTextContainsElement(tablesRowsList.get(2),genderValue);

     elementHelper.validateTextContainsElement(tablesRowsList.get(3),"Mobile");
     elementHelper.validateTextContainsElement(tablesRowsList.get(3),mobilPhoneValue);

        String subjectsStringValue = String.join( ", ", subjects);
     elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Subjects");
     elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Maths");
     elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Arts");
     elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Biology");
     elementHelper.validateTextContainsElement(tablesRowsList.get(5),"Chemistry");

     elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Hobbies");
     elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Sports");
     elementHelper.validateTextContainsElement(tablesRowsList.get(6),"Reading");


     elementHelper.validateTextContainsElement(tablesRowsList.get(7),"Picture");
    // elementHelper.validateTextContainsElement(tablesRowsList.get(7),"src/test/resources/8ek76goi.png");


        elementHelper.validateTextContainsElement(tablesRowsList.get(8),"Address");
     elementHelper.validateTextContainsElement(tablesRowsList.get(8),currentAddressValue);

     elementHelper.validateTextContainsElement(tablesRowsList.get(9),"State and City");
     elementHelper.validateTextContainsElement(tablesRowsList.get(9),stateInputValue);
     elementHelper.validateTextContainsElement(tablesRowsList.get(9),cityInputValue);


    }
}