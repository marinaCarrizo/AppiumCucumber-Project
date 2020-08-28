package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

public class BasicActions {
    private WebDriverWait wait = null;
    public AppiumDriver driver;

    public BasicActions(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isElementVisible(MobileElement element) {
        this.wait = new WebDriverWait(this.driver, 30);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public WebElement findElement(By locator) {
        this.wait = new WebDriverWait(this.driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElement(MobileElement element) {
        this.wait = new WebDriverWait(this.driver, 30);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
