package com.telran.tests.element;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectLinks();
    }

    @Test
    public void checkLinks() {
        new LinksPage(driver).checkAllLinks().checkBrokenLinks();
    }

    @Test
    public void checkMessageForLinkTest() {
        new LinksPage(driver).checkMessageForLink();
        Assert.assertTrue(new LinksPage(driver).getTextLinkResponseForLink().contains("status"));
    }
}
