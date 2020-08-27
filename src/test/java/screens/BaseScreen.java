package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.util.NoSuchElementException;

public class BaseScreen {
    protected AppiumDriver driver;
    protected Hooks hooks;
    protected WebDriverWait wait=null;

    public BaseScreen (Hooks hooks){
        this.hooks=hooks;
        this.driver= hooks.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public boolean isElementVisible(MobileElement element){
        this.wait=new WebDriverWait(this.driver, 30);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException e){
            return false;
        }

    }

}
