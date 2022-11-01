package com.telran.tests.bookstore;

import com.telran.data.UserData;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.bookstore.LoginPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton();
    }

    @Test
    public void loginPositiveTest(){
//        new LoginPage(driver).hideAdvertising();
//        new LoginPage(driver).hideFooter();
        new LoginPage(driver).login(UserData.USER_Name, UserData.USER_Password);
        new ProfilePage(driver).verifyUserName(UserData.USER_Name);

    }

    @Test
    @Parameters({"name", "password"})
    public void loginPositiveParametersTest(String name, String password){
        new LoginPage(driver).hideAdvertising();
        new LoginPage(driver).hideFooter();
//        new LoginPage(driver).login(UserData.USER_Name, UserData.USER_Password);
        new LoginPage(driver).login(name, password);
//        new ProfilePage(driver).verifyUserName(UserData.USER_Name);
        new ProfilePage(driver).verifyUserName(name);

    }

    @AfterMethod
    public void logOut(){
        new ProfilePage(driver).logOut();
    }
}
