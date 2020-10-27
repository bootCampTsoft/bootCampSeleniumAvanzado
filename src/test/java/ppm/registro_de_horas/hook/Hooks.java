package ppm.registro_de_horas.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setupScenario(Scenario scenario) {
        System.out.println("[LOG - Cucumber]"+scenario.getName());
    }

    @After
    public void teardownScenario(Scenario scenario) {
        System.out.println("[LOG - Cucumber]"+scenario.getName());
    }
}
