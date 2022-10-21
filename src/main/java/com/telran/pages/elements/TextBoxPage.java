package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}

