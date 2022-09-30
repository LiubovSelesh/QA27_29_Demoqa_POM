package com.telran.tests;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton() ;  // change class
//        new LoginPage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_Name, UserData.USER_Password);
        new ProfilePage(driver).verifyUserName(UserData.USER_Name);



    }

    @Test
    public void searchBookForLoginUserPositiveTest() {
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_Name);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_Name));
    }
}
