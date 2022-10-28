package com.telran.tests.element;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UpLodAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class UpLodAndDownloadTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectUploadDownload();
    }

    @Test
    public void robotKeyEventTest() throws AWTException {
        new UpLodAndDownloadPage(driver).performEventKeyUsingRobot();
        Assert.assertTrue(new UpLodAndDownloadPage(driver).gePath().contains("D1.txt"));
    }




    @Test
    public void robotMouseEventTest() {
        new UpLodAndDownloadPage(driver).performMouseEventUsingRobot();
    }
}



