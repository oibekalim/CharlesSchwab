package com.schwab.ui.login.pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.schwab.ui.login.utilities.BrowserUtils;
import com.schwab.ui.login.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Login_Pages {
    public Login_Pages() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//iframe[@id='LoginComponentForm']")
    public WebElement iframeLogin;

    @FindBy(css = "#LoginId")
    public WebElement login;


    @FindBy(css = "#Password")
    public WebElement password;


    @FindBy(css = "#loginSubmitButton")
    public WebElement loginButton;

    @FindBy(css = "#StartIn")
    public WebElement startin;


    @FindBy(xpath = "//span[@id=\"lms-ar-error-message\"]")
    public WebElement errorCredentialMessage;

//    Select dropdownList = new Select(Driver.getDriver().findElement(By.xpath("//*[@id=\"lms-login-section\"]")));
//    List<WebElement> listOptions = dropdownList.getOptions();





}
