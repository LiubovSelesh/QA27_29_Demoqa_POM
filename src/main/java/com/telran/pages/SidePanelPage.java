package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;

public class SidePanelPage extends BasePage {

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".show #item-3")
    WebElement profileButton;
    public ProfilePage selectProfile() {
        clickWithJSExecutor(profileButton, 0, 300);
//        clickWithAction(driver);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = " //span[.='Alerts']")
    WebElement alertsButton;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alertsButton, 0, 300);
        return new AlertsPage(driver);
    }
}


////*[contains(text(),'Profile')]

// .show #item-1
//  //span[.='Alerts']