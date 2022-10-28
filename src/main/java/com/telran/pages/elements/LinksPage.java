package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "created")
    WebElement created;

    @FindBy(id = "no-content")
    WebElement noContent;

    @FindBy(id = "moved")
    WebElement moved;

    @FindBy(id = "bad-request")
    WebElement badRequest;


    @FindBy(id = "unauthorized")
    WebElement unauthorized;

    @FindBy(id = "forbidden")
    WebElement forbidden;

    @FindBy(id = "invalid-url")
    WebElement invalidURL;

    @FindBy(id = "linkResponse")
    WebElement linkResponse;


    public LinksPage checkMessageForLink() {

        clickWithJSExecutor(unauthorized, 0, 300);
        System.out.println(linkResponse.getText());
        return this;
    }
        public String getTextLinkResponseForLink() {
            return linkResponse.getText();
    }

}






















