package Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/Login.feature","src/test/features/filter.feature"},
        glue = "StepDef",
        tags = "@Login", //Tag from login.feature
        plugin = {"pretty","html:target/RegressionReport.html"}
)
public class run {
}
