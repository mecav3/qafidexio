package org.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.util.ConfigurationReader;

import java.time.Duration;
import java.time.LocalTime;

public class Driver {
    private Driver() {
    }

    //  private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--lang=en");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    System.out.println("CREATED DRIVER " + LocalTime.now());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
            }

        }
        System.out.println("called driver " + LocalTime.now());

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
