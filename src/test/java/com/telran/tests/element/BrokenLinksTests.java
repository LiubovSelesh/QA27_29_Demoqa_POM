package com.telran.tests.element;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrokenLinksImagesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectBrokenLinksImages();
    }

    @Test
    public void checkBrokenLinksTest() {
        new BrokenLinksImagesPage(driver).checkAllLinks().checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}
