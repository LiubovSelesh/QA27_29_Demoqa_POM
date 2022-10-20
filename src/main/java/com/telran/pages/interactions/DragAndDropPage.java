package com.telran.pages.interactions;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        hideAdvertising();
        hideFooter();

        Actions actions = new Actions(driver);
        pause(500);
        actions.dragAndDrop(dragMe, dropHere).build().perform();

        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        hideAdvertising();
        hideFooter();
        Actions actions = new Actions(driver);
        //from
        int xOffSet = dragMe.getLocation().getX();
        int yOffSet = dragMe.getLocation().getY();
        System.out.println("xOffSet --> " + xOffSet + " yOffSet --> " + yOffSet);

        //to
        int xOffSetTo = dropHere.getLocation().getX();
        int yOffSetTo = dropHere.getLocation().getY();
        System.out.println("xOffSetTo --> " + xOffSetTo + " yOffSetTo --> " + yOffSetTo);

        xOffSetTo = (xOffSetTo - xOffSet) + 40;
        yOffSetTo = (yOffSetTo - yOffSet) + 80;

        actions.dragAndDropBy(dragMe, xOffSetTo, yOffSetTo).perform();
        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        return this;
    }
}
