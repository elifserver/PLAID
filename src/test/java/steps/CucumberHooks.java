package steps;

import com.framework.base.TestBase;
import com.framework.factory.AppiumDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CucumberHooks extends TestBase {
    @Before
    public void setup(Scenario scenario) throws IOException {
        AppiumDriverFactory appiumDriverManager = new AppiumDriverFactory();
        driver = appiumDriverManager.createDriver();
        wait = new WebDriverWait(driver, 10);
        startRecording();
    }

    @After
    public void tierDown(Scenario scenario) {
        stopRecording(scenario.getName() + scenario.getLine() + scenario.getStatus());
    }
}
