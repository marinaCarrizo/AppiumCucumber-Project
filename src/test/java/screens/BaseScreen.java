package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;
import utils.BasicActions;


public class BaseScreen {
    protected AppiumDriver driver;
    protected Hooks hooks;
    protected BasicActions basicActions;
    protected WebDriverWait wait;

    public BaseScreen (Hooks hooks){
        this.hooks=hooks;
        this.driver= hooks.getDriver();
        this.basicActions=new BasicActions(this.driver);
        this.wait=new WebDriverWait(this.driver,30);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

}
