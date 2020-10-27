package ppm.registro_de_horas.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ppm/registro_de_horas/features",
        glue = "ppm.registro_de_horas.step_definitions",
        plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json"},
        stepNotifications = true)
public class UnSoloParteDeHorasPorPeriodoDeTiempoTestNG extends AbstractTestNGCucumberTests {
}
