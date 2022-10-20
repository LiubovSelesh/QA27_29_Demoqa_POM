package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.nio.channels.AcceptPendingException;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[contains(text(),'Main Item 2')]")
    WebElement mainItem2;

    @FindBy(xpath = "//*[contains(text(),'SUB SUB LIST »')]")
    WebElement subSubList;

    @FindBy(xpath = "//a[contains(text(),'Sub Sub Item 2')]")
    WebElement subSubItem2;

    public MenuPage selectSubMenu() {
        Actions actions = new Actions(driver);
// move hover menu options ""Main Item 2"
        actions.moveToElement(mainItem2).perform();
// move hover menu options "Sub Sub List"
        actions.moveToElement(subSubList).perform();
// move hover menu options "Sub Sub Item 2"
        actions.moveToElement(subSubItem2).perform();
        return this;
    }
}

//