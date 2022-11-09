package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
features="src/test/resources/Features/TradeMe.feature",
glue="stepDef", plugin= {"json:target/cucmber-reports/cucmber.jason"}
)

		


public class Runner extends AbstractTestNGCucumberTests{
	
}
