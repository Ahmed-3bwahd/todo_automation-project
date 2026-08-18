package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    //Find Welcome Message element
    @FindBy(css = "[data-testid=\"welcome\"]")
    WebElement successWelcomeMessage;

    //Find no todos Message element
    @FindBy(css = "[data-testid=\"no-todos\"]")
    WebElement noTodosMessage;

    //Find Add button Element
    @FindBy(css = "[data-testid=\"add\"]")
    WebElement addTodoButton;

    //Find new Item Name Element
    @FindBy(css = "[data-testid=\"todo-item\"]")
    WebElement todoItemName;

    //Find Delete Button Element
    @FindBy(css = "[data-testid=\"delete\"]")
    WebElement deleteButton;

    //welcome BY to used in wain
    public By welcomeMessageBy(){
        return By.cssSelector("[data-testid=\"welcome\"]");
    }

    //New task name BY to use in wait
    public By todoItemBy(){
        return By.cssSelector("[data-testid=\"todo-item\"]");
    }

    //No tasks message BY to use in wait
    public By noTodoBy(){
        return By.cssSelector("[data-testid=\"no-todos\"]");
    }


    @Step("Check if the user navigated to the todo page and the welcome message is displayed")
    //Check if the welcome message is displayed
    public boolean isWelcomeMessage(){
        wait.waitForVisibility(welcomeMessageBy());
        return successWelcomeMessage.isDisplayed();
    }

    @Step("Check that the todo list is empty after removing the task")
    //Check if the no todos message is displayed
    public boolean isNoTodosMessageDisplayed(){
        wait.waitForVisibility(noTodoBy());
        return noTodosMessage.isDisplayed();
    }

    //Click on tha add button
    public NewTodoPage clickAddButton(){
        wait.waitForVisibility(addTodoButton);
        addTodoButton.click();
        return new NewTodoPage(driver);
    }

    @Step("Click on the delete button")
    //click on the delete button
    public TodoPage clickDeleteButton(){
        wait.waitForVisibility(deleteButton);
        deleteButton.click();
        return this;
    }

    @Step("Get the task name from the list and check if it matches the new added task")
    //Get The new task name
    public String getItemName(){
        wait.waitForVisibility(todoItemBy());
        return todoItemName.getText();
    }

    @Step("Load the todo page after injection the cookies in the browser")
    //Load the task page
    public TodoPage loadTodoPage(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoints.todoPageEndPoint);
        return this;
    }



}
