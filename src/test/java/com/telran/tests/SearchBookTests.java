package com.telran.tests;

import com.telran.data.BookData;
import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
    }

    @Test
    public void searchBookForGuestPositiveTest() {
//        String text = "Git";   //the possibility is creating variable
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_Name);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_Name));
    }


}
