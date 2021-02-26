package steps;

import com.framework.base.TestBase;
import io.cucumber.java.en.And;

public class GeneralSteps extends TestBase {
    @And("User waits for a while")
    public void waitForAWhile() {
        waitFor2Seconds();
    }
}
