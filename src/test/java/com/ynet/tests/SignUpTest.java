package com.ynet.tests;

import com.ynet.webpages.LoginlPage;
import com.ynet.webpages.SignUpPage;
import com.ynet.webpages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        //use Chrome Driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLogin() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLoginButton();

        //Create object of LoginlPage
        LoginlPage devportal= new LoginlPage(driver);

        //Check if page is opened
        Assert.assertTrue(devportal.isPageOpened());

        //Click on Join Toptal
     //   devportal.clikOnJoin();

        //Create object of SignUpPage
        SignUpPage applyPage =new SignUpPage(driver);

        //Check if page is opened
        Assert.assertTrue(applyPage.isPageOpened());

        //Fill up data
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");
        applyPage.setDeveloper_skype("automated_test_skype");

        //Click on join
        //applyPage.clickOnJoin();
    }

    @AfterTest
    public void close(){
        driver.close();
    }

}
