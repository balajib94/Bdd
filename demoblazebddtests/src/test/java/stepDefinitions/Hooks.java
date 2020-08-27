package stepDefinitions;


import io.cucumber.core.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger("test");
    @Before
    public void beforeScenario(Scenario sc){
        log.info("Scenario Name: "+sc.getName());
        log.info("Scenario ID: "+sc.getId());
    }
    @After
    public void afterScenario(Scenario sc){
        log.info("Scenario Status: "+sc.getStatus());
    }
}
