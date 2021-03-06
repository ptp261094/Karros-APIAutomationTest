package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//				  dryRun = true,
                  features = "src/test/java/features",
                  glue = {"stepDefinitions"},
                  monochrome = true,
                  snippets = SnippetType.CAMELCASE,
                  tags = {"@demo"}
                )
public class CucumberTestRunner {

}
