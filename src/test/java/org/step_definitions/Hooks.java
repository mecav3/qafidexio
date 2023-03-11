package org.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.util.Driver;

public class Hooks {

//    @Before(order = 2)
//    public static void setupScenario() {
//        System.out.println("setting things @Before");
//    }

    @After
    public void teardownscenario(Scenario scenario) {
        System.out.println("---closing browser @After");

     if (scenario.isFailed()) {
         byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot, "image/png", scenario.getName());
     }
    // Driver.closeDriver();
    }
//
//    @BeforeStep
//    public void setup() {
//        System.out.println("before step setup @BeforeStep");
//    }

 }
