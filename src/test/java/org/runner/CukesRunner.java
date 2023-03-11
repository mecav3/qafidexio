package org.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", // summary on console
                "json:target/cucumber.json",
        // plugin = {"html:cucumber-report.html",
        // "json:target/cucumber.json",
        // "junit:target/junit/junit-report.xml",
          "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "src/test/resources/features",
        glue = "org/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = false     // report link on console

)

public class CukesRunner {

}
