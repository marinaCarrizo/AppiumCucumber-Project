package screens;

import com.google.inject.Inject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Hooks;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "username")
    private MobileElement userField;
    @AndroidFindBy(accessibility = "password")
    private MobileElement passwordField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='login']/android.widget.Button")
    private MobileElement loginButton;
    @AndroidFindBy(id = "android:id/message")
    private MobileElement invalidCredAlert;

    @Inject
    public LoginScreen(Hooks hooks) {
        super(hooks);
    }

    //method to enter the username
    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(userField)).sendKeys(username);
    }

    //method to input the password
    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    //method to tap the login button
    public void tapLoginButton() {
        loginButton.click();
    }

    //method to get the alert text
    public String getInvalidCredsAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(invalidCredAlert)).getText();
    }
}
