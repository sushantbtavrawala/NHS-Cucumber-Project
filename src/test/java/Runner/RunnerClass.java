package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = {"Steps"},
        plugin = {"json:target/cucumber-report/cucumber.json"})

public class RunnerClass {

}