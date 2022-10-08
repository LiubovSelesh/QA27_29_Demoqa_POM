package com.telran.tests.bookstore;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.*;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.bookstore.LoginPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton() ;
        new LoginPage(driver).login(UserData.USER_Name, UserData.USER_Password);
//        new ProfilePage(driver).verifyUserName(UserData.USER_Name);



    }

    @Test
    public void searchBookForLoginUserPositiveTest() {
//        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_Name));
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_Name)
                .clickOnBookTitleLink()
                .clickOnAddBookButton().acceptAlert();
        new SidePanelPage(driver).selectProfile();

//      Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains("Git"));
    }


    @AfterMethod
    public void deleteBookFromCollection(){
        new ProfilePage(driver).deleteBook();
    }

}
