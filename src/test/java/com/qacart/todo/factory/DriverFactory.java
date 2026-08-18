package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;
    protected WebDriverWait wait;

    public DriverFactory initWebDriver(){

        String browser = System.getProperty("browser", "CHROME");

        switch (browser){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                //Use Private Mode
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--incognito");
                driver = new EdgeDriver(edgeOptions);
                break;

            default: throw new RuntimeException("the browser is not found");
        };

        //Maximize the browser
        driver.manage().window().maximize();
        return this;
    }

    public WebDriver getDriver(){
        return driver;
    }

}
