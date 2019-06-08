package com.ynet.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.ynetshops.co.il";

    //Locators

    //Login button
    @FindBy(xpath = "//*[@id=\"TabBlock-1\"]/ul/li[2]/a")
    private WebElement loginButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton(){

        loginButton.click();
        Reporter.log("Pressed on התחבר" , true);

    }

}
