package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Find Email Field
    @FindBy(css = "[data-testid=\"email\"]")
    WebElement emailInput;

    //Find Password Field
    @FindBy(css = "[data-testid=\"password\"]")
    WebElement passwordInput;

    //Find Submit button
    @FindBy(css = "[data-testid=\"submit\"]")
    WebElement submitButton;


    @Step("Enter a valid email and password")
    //Interact with elements and login
    public TodoPage login(String email, String pass){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
        submitButton.click();

        return new TodoPage(driver);
    }

    @Step("Load the application login page")
    //navigate to the ;ink
    public LoginPage loadLink(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
}
