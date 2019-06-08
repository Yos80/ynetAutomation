package com.ynet.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

    private WebDriver driver;

    //Page URL
    private static String PAGE_URL = "https://www.ynetshops.co.il";

    //Locators

    //Login button
    @FindBy(xpath = "//*[@id=\"TabBlock-1\"]/ul/li[2]/a")
    private WebElement loginButton;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchBtn;

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton() {

        loginButton.click();
        Reporter.log("Pressed on התחבר", true);

    }

    public void clickOnSearchButton() {

        searchBtn.click();
        Reporter.log("Pressed on search button", true);

    }

    public void insertValueInSearchField(String product) {

        searchField.sendKeys(product);
        Reporter.log("The word " + product + " is inserted", true);

    }


    //We will use this  for assertion. To check if its the correct color
    public void BtnColor(String color) {

        if (Color.fromString(searchBtn.getCssValue("background-color")).asHex().contains(color))
            Reporter.log("Color is correct", true);
        else {
            Reporter.log("Color is incorrect", true);
        }


    }

}