package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/java/ThermoFisherAssignment/FeatureFiles/"},
    glue = {"ThermoFisherAssignment.stepFiles"},
    plugin = {"pretty","html:target/cucmber","jason:target/cucumber.jason","com.cucmber.listner.ExtentCucumberFormatter:target/report.html"}
)
public class mainRunner {

	
}
