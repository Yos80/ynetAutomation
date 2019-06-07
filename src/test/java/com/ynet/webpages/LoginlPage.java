package com.ynet.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginlPage {

    private WebDriver driver;

    @FindBy(css = "#customer-login-form > div > div.well > p > strong")
    private WebElement loginPageText;

    @FindBy(id = "login-email")
    private WebElement loginEmailField;

    @FindBy(id = "login-password")
    private WebElement loginPasswordField;

    @FindBy(css = "a")
    private WebElement forgetPassLink;

    @FindBy(xpath = "//*[@id=\"customer-forgot-form\"]/div/div[1]/h2/text()")
    private WebElement forgetPassWizard;

    @FindBy(xpath = "//*[@id=\"customer-login-form\"]/div/div[2]/input[2]")
    private WebElement submitBtn;

    @FindBy(css = "#content > div > div > div > div > div > p > a")
    private WebElement loginConfirmed;

    @FindBy(css = "#customer-login-form > div > div.well > div.alert.alert-danger > strong")
    private WebElement loginFailedMessage;

    //Constructor
    public LoginlPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);

    }

    public void setloginEmail(String email) {
        loginEmailField.clear();
        loginEmailField.sendKeys(email);
        Reporter.log("Entered email" , true);
    }

    public void setloginPassword(String password) {
        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
        Reporter.log("Entered password" , true);
    }

    public void forgetPass() {
        forgetPassLink.click();
        Reporter.log("Pressed forget password" , true);
    }

    public void pressSubmit() {
        submitBtn.click();
        Reporter.log("Pressed submit button" , true);
    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isPageOpened() {
        Reporter.log("Page is open" , true);
        return loginPageText.getText().contains("אני לקוח קיים");
    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isForgetPassWizardOpen() {
        return forgetPassWizard.getText().contains((" איפוס סיסמה"));
    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isLoginSuccessful() {
        Reporter.log("User is logged in! " , true);
        return loginConfirmed.getText().contains("לחץ כאן להתנתקות והתחברות עם משתמש אחר");

    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isLoginFailed() {
        Reporter.log("Wrong credentials!, login failed" , true);
        return loginFailedMessage.getText().contains("שגיאת התחברות!");


    }
}