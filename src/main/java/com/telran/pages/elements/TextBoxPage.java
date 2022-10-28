package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;


    public TextBoxPage fillDataUser(String fullName, String email, String curAddress, String perAddress) {
        type(userName, fullName);
        type(userEmail, email);
        typeWithJSExecutor(currentAddress, curAddress, 0, 300);
        type(permanentAddress, perAddress);
        return this;
    }


    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage submitButton() {
        clickWithJSExecutor(submit, 0, 500);
        return this;
    }

    @FindBy(id = "output")
    WebElement output;

    public String getTextFromData() {
        return output.getText();
    }

    public TextBoxPage keyBoardEvent() {
//enter username;
        type(userName, "Tom Tompson");
//enter email;
        type(userEmail, "tompson@gm.com");
// enter current address;
        typeWithJSExecutor(currentAddress, "Berlinerplatz 123, 123456 Berlin", 0, 200);
// create object of the Action class;
        Actions actions = new Actions(driver);
//        pause(500);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
// select current address;
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
// press the tab Key to switch focus to permanent address;
        actions.sendKeys(Keys.TAB).perform();
// past the current address in the permanent address field;
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//        click(submit);
//        System.out.println(currentAddress.getAttribute("value"));
//        System.out.println(permanentAddress.getAttribute("value"));
        return this;

    }

    public String getAttribute() {
        return permanentAddress.getAttribute("value");
    }
}

//output