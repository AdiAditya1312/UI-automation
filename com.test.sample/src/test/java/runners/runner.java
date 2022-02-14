package runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = {
     "src/test/resources/featureFiles/loanCalculator.feature"
    },
      glue = { "stepdefinitions" },plugin = { "pretty",
    	        "html:target/cucumber-html-report", "json:target/cucumber-report/Cucumber.json",
    	        "junit:target/cucumber-report/Cucumber.xml",
    	         }, tags = "@Smoke" , dryRun = false)

public class runner {

  

}
