package com.qacart.todo.apis;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookie;
    private String accessToken;
    private String firstName;
    private String userID;

    public void register(){

        User user = new UserUtils().generateRandomUser();

        Response response = given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type", "application/json")
                .body(user)
        .when()
                .post(EndPoints.registerEndPoint)
        .then()
                .extract().response();

        if(response.statusCode() != 201){
          throw new RuntimeException("something went wrong with the register API");
        }

        restAssuredCookie = response.detailedCookies().asList();
        accessToken= response.path("access_token");
        firstName= response.path("firstName");
        userID= response.path("userID");

    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookie;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserID() {
        return userID;
    }

}
