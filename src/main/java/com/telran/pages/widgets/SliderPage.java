package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement slider;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage moveSliderInHorizontalDirection() {
        Actions actions = new Actions(driver);
//move mouse to x offset 50 i.e. in horizontal direction
        actions.dragAndDropBy(slider, 80, 0).perform();
//        actions.moveToElement(slider, 90, 0).perform();
//        click(slider);
        return this;
    }
}

