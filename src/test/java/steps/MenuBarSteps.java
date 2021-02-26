package steps;

import com.framework.base.Base;
import com.framework.pages.welcomePage.WelcomePageBody;
import com.framework.pages.welcomePage.WelcomePageMenuBar;
import com.framework.pages.welcomePage.WelcomePage;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MenuBarSteps {

    @Given("User is opened the app")
    public void userIsOpenedTheApp() {
        WelcomePage.openApp();
    }

    @Then("app name should be {string}")
    public void checkIfAppNameIs(String appName) {
        Assert.assertEquals(appName, WelcomePageMenuBar.getAppNameOnTheLeftTop());
    }

    @Then("page theme should become {string}")
    public void isPageTheme(String theme) {
        String darkLight = WelcomePageMenuBar.themeDarkLight();
        switch (theme) {
            case "dark theme":
                Assert.assertEquals("wrong theme, are you sure you clicked the icon?? Expected DARK", "dark", darkLight);
                break;
            case "light theme":
                Assert.assertEquals("wrong theme, are you sure you clicked the icon?? Expected LIGHT", "light", darkLight);
                break;
        }
    }

    @Then("User should see {int} icons on the bar")
    public void menuIconCountCheck(int iconCount) {
        List<MobileElement> iconList = WelcomePageMenuBar.getListOf("ClickableElementsOnTheMenu");
        Assert.assertEquals("Check the menu bar, it seeme like there is a change!", iconCount, iconList.size());
    }

    @Given("User unselects all the selected items")
    public void unselectAllTheFilters() {
        List<MobileElement> iconList = WelcomePageMenuBar.getListOf("FilterSection");
        for (MobileElement icon : iconList) {
            if (icon.getAttribute("enabled").equalsIgnoreCase("true")) {
                icon.click();
            }
        }
    }

    @Then("User should see no filter selected warning")
    public void filterWarningCheck() {
        WelcomePage.clickButtonOnPhone("back");
        Assert.assertEquals(WelcomePageBody.isWarningVisible(), true);
    }

    @Given("User unselected all the selected filters")
    public void userUnselectedAllTheSelectedFilters() {
        userSelectsMenuItem("Filter");
        unselectAllTheFilters();
    }

    @And("User selects {string}")
    public void userSelects(String filterName) {
        WelcomePageMenuBar.selectFilter(filterName);
    }

    @Then("User should see results on the welcome screen")
    public void userShouldSeeResultsOnTheWelcomeScreen() {
        WelcomePage.clickButtonOnPhone("back");
        Assert.assertEquals("No results coming for the filter. Please check if the data to understand if this is the expected behaviour",
                WelcomePageBody.isWarningVisible(), false);
    }

    @When("User selects option {string}")
    public void userSelectsOption(String optionLabel) {
        WelcomePageMenuBar.selectOptionMenuItem(optionLabel);
    }

    @Then("Application should navigate to proper page")
    public void applicationCrashCheck() {
        Assert.assertFalse("Application crashed!! Page should navigate to the proper page instead.", WelcomePageMenuBar.isApplicationCrashed());
    }

    @Then("Menu item {string} should be working properly")
    public void menuItemShouldBeWorkingProperly(String menuItem) {
        WelcomePageMenuBar.selectMenuItem(menuItem);
        applicationCrashCheck();
    }

    @When("User selects menu item {string}")
    public void userSelectsMenuItem(String iconName) {
        WelcomePageMenuBar.selectMenuItem(iconName);
    }

    @Then("User should see {string} as selected")
    public void isFilterSelected(String filter) {
        String filterSelected = WelcomePageMenuBar.isFilterSelected(filter);
        Assert.assertTrue("Specified Filter should be selected", filterSelected.equalsIgnoreCase("true"));
    }
}
