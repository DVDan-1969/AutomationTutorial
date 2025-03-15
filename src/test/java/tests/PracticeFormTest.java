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
        for (int index = 0; index < subjects.size(); index++) {
            subjectsElement.sendKeys(subjects.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectsElement,subjects.get(index),Keys.ENTER);
        }
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");

        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
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
        String stateValue = "NCR";
       elementHelper.fillPressLocator(stateInputElement,stateValue,Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

        By cityInputElement = By.id("react-select-4-input");
        String cityValue="Delhi";
        elementHelper.fillPressLocator(cityInputElement,cityValue,Keys.ENTER);

        By submitButtonElement = By.id("submit");
        elementHelper.clickLocator(submitButtonElement);
        //Validari

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        WebElement thankYouElement= driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage="Thanks for submitting the form";
        String actualMessage= thankYouElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        List<WebElement> rowsList=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(rowsList.get(0).getText().contains("Student Name"));
        Assert.assertTrue(rowsList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(rowsList.get(0).getText().contains(lastNameValue));

        Assert.assertTrue(rowsList.get(1).getText().contains("Student Email"));
        Assert.assertTrue(rowsList.get(1).getText().contains(emailValue));

        Assert.assertTrue(rowsList.get(2).getText().contains("Gender"));
        Assert.assertTrue(rowsList.get(2).getText().contains(genderValue));


        String subjectsStringValue = String.join( ", ", subjects);
        Assert.assertTrue(rowsList.get(5).getText().contains("Subjects"));
        System.out.println(rowsList.get(5).getText());
        System.out.println(subjectsStringValue);
        Assert.assertTrue(rowsList.get(5).getText().contains(subjectsStringValue));



    }
}