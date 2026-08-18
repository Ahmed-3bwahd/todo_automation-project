package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with valid email and password")
    @Description("Test case to check that the user can login with a valid email and password and navigate to the todo page")
    @Test(description = "Check that the user can login successfully")
    public void shouldBeAbleToLogin(){

        LoginPage loginPage = new LoginPage(getDriver());

        boolean isWelcomeDisplayed =
                loginPage.loadLink() // open the website url
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword()) // enter the credentials and return new class page
                        .isWelcomeMessage(); // check if the message in a new page is displayed
        Assert.assertTrue(isWelcomeDisplayed);


    }

}