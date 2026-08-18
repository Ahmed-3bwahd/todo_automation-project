package com.qacart.todo.testcases;

import com.qacart.todo.apis.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class AddNewTodoTest extends BaseTest {

    @Story("Add new task")
    @Description("Test case to check the user can add new task and verify that the task is added in the todo list")
    @Test(description = "Check that the user can add new task successfully")
    public void shouldBeAbleToAddNewTask(){
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        String newTask = loginPage.loadLink()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .clickAddButton()
//                .enterNewTask("Learn new course")
//                .getItemName();

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.loadNewTaskPage();
        injectCookieIntoBrowser(registerApi.getRestAssuredCookies());

        String newTask =
                newTodoPage.loadNewTaskPage()
                .enterNewTask("Learn new course")
                .getItemName();

        Assert.assertEquals(newTask, "Learn new course");

    }
}
