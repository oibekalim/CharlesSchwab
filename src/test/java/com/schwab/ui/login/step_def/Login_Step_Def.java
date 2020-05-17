package com.schwab.ui.login.step_def;

import com.schwab.ui.login.pages.Login_Pages;
import com.schwab.ui.login.utilities.BrowserUtils;
import com.schwab.ui.login.utilities.ConfigurationReader;
import com.schwab.ui.login.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login_Step_Def {

    Login_Pages login_pages = new Login_Pages();

    @Given("User on the home page schwab.com")
    public void user_on_the_home_page_schwab_com() {
        Driver.getDriver().getTitle();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Then("User {string} logs in wrong password and wrong loginID")
    public void user_logs_in_wrong_password_and_wrong_loginID(String signinOptions) {
        Driver.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        String errorExpectedMessage = "The Login ID or Password is invalid.";

        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("#LoginComponentForm"));

        switch (signinOptions) {

            case "Accounts Summary":
                Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                Driver.getDriver().switchTo().frame(iframe);

                WebElement selectElement = Driver.getDriver().findElement(By.cssSelector("#StartIn"));
                Select dropdownList = new Select(selectElement);
                List<WebElement> listOptions = dropdownList.getOptions();
                for (WebElement options : listOptions) {
                    System.out.println(options.getText());
                }

                BrowserUtils.waitForVisibility(login_pages.login, 10);
                login_pages.login.sendKeys("");
                login_pages.password.sendKeys("234df");
                login_pages.loginButton.click();
                Assert.assertEquals(errorExpectedMessage, login_pages.errorCredentialMessage.getText());
                break;

            case "Positions":
                Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                Driver.getDriver().switchTo().frame(iframe);
                Select positions = new Select(Driver.getDriver().findElement(By.cssSelector("#StartIn")));
                positions.selectByVisibleText("Positions");
                BrowserUtils.waitForVisibility(login_pages.login, 9);
                login_pages.login.sendKeys("charles");
                login_pages.password.sendKeys("");
                login_pages.loginButton.click();
                Assert.assertEquals(errorExpectedMessage, login_pages.errorCredentialMessage.getText());
                break;

            case "Order Status":
                Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
                Driver.getDriver().switchTo().frame(iframe);
                Select orderStatus = new Select(Driver.getDriver().findElement(By.cssSelector("#StartIn")));
                orderStatus.selectByVisibleText("Order Status");
                BrowserUtils.waitForVisibility(login_pages.login, 9);
                login_pages.login.sendKeys("schwab");
                login_pages.password.sendKeys("24dffd");
                login_pages.loginButton.click();
                Assert.assertEquals(errorExpectedMessage, login_pages.errorCredentialMessage.getText());
                break;

        }

    }

}
