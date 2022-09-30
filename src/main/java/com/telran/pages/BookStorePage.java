package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {  // move to LoginPage
        click(loginButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchBookInput(String bookName) {
        typeWithJSExecutor(searchInput, bookName, 0, 600 );
        return this;
    }

    @FindBy(css = ".mr-2")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }
}

