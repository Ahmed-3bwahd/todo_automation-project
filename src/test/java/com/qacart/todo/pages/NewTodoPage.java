package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    //Find New Task Field Element
    @FindBy(css = "[data-testid=\"new-todo\"]")
    WebElement newTodoInput;

    //Find Submit New Task Element
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    WebElement submitNewTask;

    @Step("Enter the new task and submit")
    //Enter new task and submit
    public TodoPage enterNewTask(String newTask){
        wait.waitForVisibility(newTodoInput);
        newTodoInput.sendKeys(newTask);
        submitNewTask.click();
        return new TodoPage(driver);
    }

    @Step("Load the new task page after injecting the cookies in the browser")
    //Load the new task page
    public NewTodoPage loadNewTaskPage(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoints.newTaskPageEndPoint);
        return this;
    }



}
