package com.telran.pages.bookstore;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage {
    public Object verifyUserName;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
//#userName-value
//#submit


   @FindBy (id = "userName-value")
   WebElement userNameValue;

    @FindBy (xpath = "//*[contains(text(),'Log out')]")
   WebElement logOutButton;

    public ProfilePage verifyUserName (String userName) {
        if (userNameValue.getText().equalsIgnoreCase(userName)) {
            System.out.println("Correct user name: " + userNameValue.getText());
        } else {
            System.out.println("Incorrect user name: " + userNameValue.getText());
        }
        return this;
    }

    public LoginPage logOut() {
        click(logOutButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "delete-record-undefined")
    List<WebElement> trashList;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public ProfilePage deleteBook() {
//        pause(500);
        trashList.get(0).click();
        pause(500);
        click(okButton);
        pause(500);
        acceptAlert();
        return this;
    }
}


//#closeSmallModal-ok