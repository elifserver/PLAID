package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"
        },
        features = "src/test/resources",
        glue = {"steps"},
        // tags = "@add"
        monochrome = true
)
public class CucumberRunner {

}
