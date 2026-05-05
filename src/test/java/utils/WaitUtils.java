package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {

    private static final int TIMEOUT = 15;

    public static WebElement waitVisible(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitClickable(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageLoad() {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(webDriver ->
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }
}