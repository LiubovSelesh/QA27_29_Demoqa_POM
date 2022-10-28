package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UpLodAndDownloadPage extends BasePage {
    public UpLodAndDownloadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UpLodAndDownloadPage performEventKeyUsingRobot() throws AWTException {
//        hideAdvertising();
//        hideFooter();
        clickWithRectangle(uploadFile, 12, 3);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public String gePath() {
        return uploadedFilePath.getText();
    }

    public UpLodAndDownloadPage performMouseEventUsingRobot() {

        pause(1000);
        clickWithRectangle(uploadFile, 12, 4);

        Robot robot = null;
        try {
            robot = new Robot();   // If we wrap in try/catch we will not add Exception
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Dimension i = driver.manage().window().getSize();
        System.out.println("x --> " + i .getWidth() + " y --> " + i.getHeight());

        int x = i.getWidth() / 3 + 250;
        int y = i.getHeight() / 10 + 420;
        robot.mouseMove(x, y);
        pause(200);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(5000);
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }
}




