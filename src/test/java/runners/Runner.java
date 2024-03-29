package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome=true,
        features = "./src/test/resources/features",
        glue = {"stepdefinitions"},
        dryRun = false,
        tags = "@js_executor"

)


public class Runner {
}



//https://reports.cucumber.io/report-collections/97640137-11f9-4e56-9b93-cf29304a8ba9   to go my report