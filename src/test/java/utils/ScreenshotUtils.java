package utils;
import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;
public class ScreenshotUtils {
public static void capture(String name) {
try {
TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
File src = ts.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("screenshots/"+name+".png"));
} catch(Exception e){ e.printStackTrace(); }
}}