package utils;

import org.openqa.selenium.*;

public class ElementActions {

    public static void click(By locator) {
        try {
            WaitUtils.waitClickable(locator).click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
            WebElement element = WaitUtils.waitVisible(locator);
            js.executeScript("arguments[0].click();", element);
        }
    }

    public static void type(By locator, String text) {
        WebElement element = WaitUtils.waitVisible(locator);
        element.clear();
        element.sendKeys(text);
    }
}