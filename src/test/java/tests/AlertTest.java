package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubMenu();

        AlertPage alertPage=new AlertPage(driver);
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithPromtAlert("Bau");

    }
}