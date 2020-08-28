package steps;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import screens.HomeScreen;
import screens.LoginScreen;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    @Inject
    LoginScreen loginScreen;
    @Inject
    HomeScreen homeScreen;

    @When("I enter my username {string}")
    public void iEnterMyUsername(String username) {
        loginScreen.setUsername(username);
    }

    @And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        loginScreen.setPassword(password);
    }

    @And("I attempt to login")
    public void iAttemptToLogin() {
        loginScreen.tapLoginButton();
    }

    @Then("I should see the Samples List")
    public void iShouldSeeTheSamplesList(DataTable dataTable) {
        List<Map<String, String>> samples = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> sample : samples)
            Assert.assertTrue(homeScreen.elementIsVisible(sample.get("Title")));
    }

    @Then("I should see the invalid credentials popup")
    public void iShouldSeeTheInvalidCredentialsPopup() {
        Assert.assertEquals(loginScreen.getInvalidCredsAlertMessage(), "Invalid  Credentials");
    }

    @Given("I login with valid credentials {string}{string}")
    public void iLoginWithValidCredentials(String user, String password) {
        loginScreen.setUsername(user);
        loginScreen.setPassword(password);
        loginScreen.tapLoginButton();

    }
}
