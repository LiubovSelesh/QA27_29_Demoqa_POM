package com.telran.tests.element;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataUserInTextBox")
    public void fillDataUserTestWithDataProvider(String name, String email,  String currentAddress, String permanentAddress) {

        new TextBoxPage(driver).fillDataUser(name, email, currentAddress,permanentAddress).submitButton();
        Assert.assertTrue(new TextBoxPage(driver).getTextFromData().contains("Current"));
    }

    @Test
    public void keyBoardEventTest () {
        new TextBoxPage(driver).keyBoardEvent();
        Assert.assertEquals(new TextBoxPage(driver).getAttribute(), "Berlinerplatz 123, 123456 Berlin");


    }
}


