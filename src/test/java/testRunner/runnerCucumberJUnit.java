package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber.html"},
        tags = "@tag",
        features = "src/test/java/features/Registration.feature",
        glue={"testRunner.testSteps"}
)
public class runnerCucumberJUnit {}

