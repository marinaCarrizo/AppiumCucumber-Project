package screens;

import com.google.inject.Inject;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import steps.Hooks;

public class NativeViewScreen extends BaseScreen {

    private final String CONTAINER_TEXT = "//android.widget.TextView[@text=\"%s\"]";

    @Inject
    public NativeViewScreen(Hooks hooks) {
        super(hooks);
    }

    public String getContainerText(String text) {
        MobileElement element = (MobileElement) basicActions.findElement(
                By.xpath(String.format(CONTAINER_TEXT, text)));
        return element.getText();
    }
}
