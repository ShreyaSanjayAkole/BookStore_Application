import org.junit.runner.RunWith;

import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature"},  // Path to your feature file
        glue = {"stepDefination"},                   // Package containing step definitions
        plugin = {"pretty", "html:target/htmlreports.html"}
)
public class TestRunner {
}

