package com.qacart.todo.apis;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class NewTaskApi {

    public static void addNewTask(String token){
        Task task = new Task("Learn Selenium66", false);

        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type", "application/json")
                        .body(task)
                        .auth().oauth2(token)
                .when()
                        .post(EndPoints.newTaskEndPoint)
                .then()
                        .log().all().extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("the new task isn't added");
        }
    }
}
