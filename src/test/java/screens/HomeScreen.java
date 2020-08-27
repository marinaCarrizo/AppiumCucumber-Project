package screens;

import com.google.inject.Inject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Hooks;
import java.util.List;
import java.util.NoSuchElementException;

public class HomeScreen extends BaseScreen{
    @AndroidFindBy(xpath ="//parent::android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    private List<MobileElement> samplesList ;

    private final String SAMPLE_ITEM= "//android.widget.TextView[@text='%s']";
    @Inject
    public HomeScreen(Hooks hooks) {
        super(hooks);
    }

    public boolean elementIsVisible(String text){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(SAMPLE_ITEM, text))));
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
