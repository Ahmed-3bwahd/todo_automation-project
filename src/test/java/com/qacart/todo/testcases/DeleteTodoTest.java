package com.qacart.todo.testcases;

import com.qacart.todo.apis.NewTaskApi;
import com.qacart.todo.apis.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
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

@Feature("Todo Feature")
public class DeleteTodoTest extends BaseTest {

    @Story("Remove the task")
    @Description("Test case to check that the user can remove the added task from the todo list")
    @Test(description = "Check that the user can delete the task")
    public void shouldBeAbleToDeleteTheTodoTask(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTaskApi.addNewTask(registerApi.getAccessToken());


        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.loadTodoPage();
        injectCookieIntoBrowser(registerApi.getRestAssuredCookies());


        boolean todoDeleted = todoPage
                .loadTodoPage()
                .clickDeleteButton()
                .isNoTodosMessageDisplayed();

        Assert.assertTrue(todoDeleted);

    }
}
