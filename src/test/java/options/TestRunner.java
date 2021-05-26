package options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue= "stepdefinations", tags="@Test")  //Used to define location of feature file and step definition file

public class TestRunner {

}
