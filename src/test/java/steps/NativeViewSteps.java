package steps;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import screens.HomeScreen;
import screens.NativeViewScreen;

import java.util.List;
import java.util.Map;

public class NativeViewSteps {

    @Inject
    NativeViewScreen nativeViewScreen;
    @Inject
    HomeScreen homeScreen;

    @When("I choose the Native View option")
    public void iChooseTheNativeViewOption() {
        homeScreen.accessNativeView();
    }

    @Then("I should see the containers")
    public void iShouldSeeTheContainers(DataTable dataTable) {
        List<Map<String, String>> containers = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> container : containers)
            Assert.assertTrue(nativeViewScreen.getContainerText(container.get("Text") + " ")
                    .contains("Hello World, I'm View " + container.get("Container")));
    }
}
