package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/features"},
        glue = {"stepDefinitions","utility"},
        tags = "@regression",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}

)
public class TestRunner {
}
