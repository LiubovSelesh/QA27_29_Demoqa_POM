package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public LinksPage checkAllLinks() {

        System.out.println("Total links on the WebPage: " + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linksURL) {
        try {
            URL url = new URL(linksURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linksURL + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(linksURL + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            System.out.println(linksURL + " - " + e.getMessage() + " is a broken link");
        }
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






















