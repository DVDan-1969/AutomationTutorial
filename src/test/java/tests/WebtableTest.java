package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebtableTest extends SharedData {




 @Test
    public void metodaTest () {

     ElementHelper elementHelper=new ElementHelper(driver);
     PageHelper pageHelper=new PageHelper(driver);



     By elementMenu= By.xpath("//h5[text()='Elements']");
  elementHelper.clickJSLocator(elementMenu);

  By webTableSubMenu=By.xpath("//span[text()='Web Tables']");
  elementHelper.clickJSLocator(webTableSubMenu);
     By tablesRowsListElement =By.xpath(
             "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']");

     List<WebElement>tablesRowList = driver.findElements(tablesRowsListElement);


//identificam un element
     By addElement = By.id("addNewRecordButton");
     elementHelper.clickJSLocator(addElement);


     By firstNameElement= By.id("firstName");
     String firstNameValue="Dan";
     elementHelper.fillLocator(firstNameElement,firstNameValue);

    By lastNameElement= By.id("lastName");
    String lastNameValue="Dudas";
     elementHelper.fillLocator(lastNameElement,lastNameValue);


    By userEmailElement= By.id("userEmail");
     String userEmailValue ="dvdudas@yahoo.com";
     elementHelper.fillLocator(userEmailElement,userEmailValue);

     By ageElement= By.id("age");
     String ageValue = "55";
     elementHelper.fillLocator(ageElement,ageValue);

     By salaryElement= By.id("salary");
     String salaryValue = "1000";
     elementHelper.fillLocator(salaryElement,salaryValue);

     By departmentElement= By.id("department");
     String departmentValue = "qa";
     elementHelper.fillLocator(departmentElement,departmentValue);

     By submitElement=By.id("submit");
     elementHelper.clickJSLocator(submitElement);

     tablesRowList = driver.findElements(tablesRowsListElement);
     Assert.assertEquals(tablesRowList.size(), 4, "Valoarea actuala a tabelului nu este 4");
     String expectedRow = tablesRowList.get(3).getText();
     Assert.assertTrue(expectedRow.contains(firstNameValue));
     Assert.assertTrue(expectedRow.contains(lastNameValue));
     Assert.assertTrue(expectedRow.contains(userEmailValue));
     Assert.assertTrue(expectedRow.contains(ageValue));
     Assert.assertTrue(expectedRow.contains(salaryValue));
     Assert.assertTrue(expectedRow.contains(departmentValue));



     //edit functionality

     By editElement= By.id("edit-record-4");
     elementHelper.clickLocator(editElement);

     By editFirstNameElement= By.id("firstName");
    String editFirstNameValue="Popescu";
     elementHelper.clearFilledLocator(editFirstNameElement,editFirstNameValue);

     By editLastNameElement = By.id("lastName");
     String editLastNameValue = "Ioana";
     elementHelper.clearFilledLocator(editLastNameElement,editLastNameValue);

     By editUserEmailElement = By.id("userEmail");
     String editUserEmailValue = "ioana.alexandra@gmail.com";
     elementHelper.clearFilledLocator(editUserEmailElement,editUserEmailValue);

     By editAgeElement = By.id("age");
     String editAgeValue = "30";
     elementHelper.clearFilledLocator(editAgeElement,editAgeValue);


     By editSalaryElement = By.id("salary");
     String editSalaryValue = "9000";
     elementHelper.clearFilledLocator(editSalaryElement,editSalaryValue);



     By editDepartmentElement = By.id("department");
     String editDepartmentValue = "Marketing";
     elementHelper.clearFilledLocator(editDepartmentElement,editDepartmentValue);


     By resubmitElement = By.id("submit");
     elementHelper.clickJSLocator(resubmitElement);

     By deleteElement=By.id("delete-record-4");
     elementHelper.clickLocator(deleteElement);

     tablesRowList = driver.findElements(tablesRowsListElement);
     Assert.assertEquals(tablesRowList.size(), 3, "Valoarea actuala a tabelului nu este 4.");



 }

}

