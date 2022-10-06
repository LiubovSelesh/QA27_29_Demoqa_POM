package com.telran.tests.element;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectButtons();
    }

    @Test
    public void doubleClick() {
        new ButtonsPage(driver).doubleClick();
    }


    @Test
    public void rightClick() {
        new ButtonsPage(driver).rightClick();

    }
}
