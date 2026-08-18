package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {

//    protected WebDriver driver;
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return this.driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @BeforeMethod
    public void initDriver(){

        WebDriver driver = new DriverFactory().initWebDriver().getDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void driverDown(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        File file = new File("target" + File.separator + "screenshots" + File.separator + testCaseName+".PNG");
        takeScreenShot(file);

        if( getDriver() != null){
            getDriver().quit();
        }
    }

    public void injectCookieIntoBrowser(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookieToSelenium(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie: seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }

    public void takeScreenShot(File destfile) {

        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destfile);

            InputStream inputStream = new FileInputStream(destfile);
            Allure.addAttachment("screenshot", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}