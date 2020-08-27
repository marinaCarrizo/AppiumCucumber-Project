package steps;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


@ScenarioScoped
public class Hooks {

    public AppiumDriver<MobileElement> driver;

    @Before
    public void setUpAppium() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_8");
        cap.setCapability(MobileCapabilityType.APP, "C:/Users/usuario/Documents/AppiumCucumber-Project/src/test/resources/app/VodQA-Android.apk");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        cap.setCapability("autoLaunch","True");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    public AppiumDriver getDriver(){
        return driver;
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
