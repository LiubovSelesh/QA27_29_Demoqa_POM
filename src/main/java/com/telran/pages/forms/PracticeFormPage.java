package com.telran.pages.forms;

import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;



    public PracticeFormPage enterPersonalData(String name, String secondName, String email, String phone) {
        type(firstName, name);
        type(lastName, secondName);
        type(userEmail, email);
        type(userNumber, phone);

        return this;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            clickWithJSExecutor(male, 0, 200);
        } else if (gender.equals("Female")) {
            clickWithJSExecutor(female, 0, 200);
        } else {
          clickWithJSExecutor(other, 0, 200);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String birthday) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthInput.sendKeys(birthday);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

// Second type of method for choose data

    @FindBy(css = ".react-datepicker__month-select")
    WebElement month;

    @FindBy(css =  ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage chooseDate(String mon, String y, String day) {
        click(dateOfBirthInput);
        //HTML <select> tag
        Select select = new Select(month);
        select.selectByVisibleText(mon);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }


    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                clickWithJSExecutor(sports,0,300);
            } if (hobbies[i].equals("Reading")) {
                clickWithJSExecutor(reading, 0, 300);
            } if (hobbies[i].equals("Music")) {
                clickWithJSExecutor(music, 0, 300);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage fillAddress(String address) {
        clickWithJSExecutor(currentAddress, 0, 300);
        type(currentAddress, address);
        return this;
    }

    public PracticeFormPage hideIframes() {
        hideAdvertising();
        hideFooter();
        return this;
    }

    @FindBy(id = "state")
    WebElement idState;

    @FindBy(id = "react-select-3-input")
    WebElement state;



    public PracticeFormPage enterState(String st) {
        click(idState);
        state.sendKeys(st);
        state.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "city")
    WebElement idCity;

    @FindBy(id = "react-select-4-input")
    WebElement city;

    public PracticeFormPage enterCity(String c) {
        click(idCity);
        city.sendKeys(c);
        city.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        clickWithRectangle(submit,3,4);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement title;


    public String getModalTitle() {
        return title.getText();
    }

    @FindBy(id = "closeLargeModal")
    WebElement close;

    public PracticeFormPage closeModalDialog() {
        closeWindowBanner();
        clickWithJSExecutor(close,0,700);
        return this;
    }

    public PracticeFormPage addAddress(String address) {
        typeWithJSExecutor(currentAddress, address, 0, 300);
        return this;
    }




}


//      public PracticeFormPage enterPersonalData(String name, String secondName, String email, String telNum) {
//        type(firstName, name);
//        type(lastName, secondName);
//        type(userEmail, email);
//        type(userNumber, telNum);
