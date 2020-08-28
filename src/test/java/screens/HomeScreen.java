package screens;

import com.google.inject.Inject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import steps.Hooks;


public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Native View']")
    private MobileElement nativeViewButton;

    private final String SAMPLE_ITEM = "//android.widget.TextView[@text='%s']";

    @Inject
    public HomeScreen(Hooks hooks) {
        super(hooks);
    }

    public boolean elementIsVisible(String text) {
        return basicActions.isElementVisible((MobileElement)
                basicActions.findElement(By.xpath(String.format(SAMPLE_ITEM, text))));
    }

    public void accessNativeView() {
        basicActions.findElement(nativeViewButton).click();
    }


}
