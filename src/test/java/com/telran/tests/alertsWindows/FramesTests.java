package com.telran.tests.alertsWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alertsWindows.FramePage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectFrame();
    }
    @Test
    public void framesTest() {
        new FramePage(driver).returnListOfFrames();
    }

    @Test
    public void switchToFrameByIndexTest(){
        new FramePage(driver).switchToFrameByIndex(1);
    }

    @Test
    public void switchToFrameByIdTest(){
        new FramePage(driver).switchToFrameById();
    }
}
