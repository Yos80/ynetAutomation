package com.ynet.tests;

import com.ynet.webpages.HomePage;
import com.ynet.webpages.LoginlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        //use Chrome Driver
        driver = new ChromeDriver();

        //use FF Driver
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.24.0/bin/geckoDriver.exe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Reporter.log("Opening browser" , true);
    }


    @Test(priority = 1)
    public void buttonColorValidation() {

        HomePage home = new HomePage(driver);
        home.BtnColor("#f4a137");


    }


    @Test(priority = 3)
    public void validLogin() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLoginButton();

        //Create object of LoginlPage
        LoginlPage login = new LoginlPage(driver);

        //Check if page opened
        Assert.assertTrue(login.isPageOpened());


        //Fill up data
        login.setloginEmail("jojo@mailinator.com");
        login.setloginPassword("Jj123456");
        login.pressSubmit();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Check if page is opened
        Assert.assertTrue(login.isLoginSuccessful());
    }

        @Test(priority = 2)
        public void inValidLogin () {
            //Create object of HomePage Class
            HomePage home = new HomePage(driver);
            home.clickOnLoginButton();


            //Create object of LoginlPage
            LoginlPage login = new LoginlPage(driver);

            //Check if page is opened
            Assert.assertTrue(login.isPageOpened());



            //Fill up data
            login.setloginEmail("dejan@toptal.com");
            login.setloginPassword("Jj123456");
            login.pressSubmit();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //Check if page is opened
            Assert.assertTrue(login.isLoginFailed());


        }

        @AfterTest
        public void close () {
            driver.close();
            Reporter.log("Closing browser" , true);
        }

    }
