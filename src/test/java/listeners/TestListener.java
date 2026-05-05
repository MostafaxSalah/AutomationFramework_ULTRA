package listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;
public class TestListener implements ITestListener {
public void onTestFailure(ITestResult result) {
ScreenshotUtils.capture(result.getName());
}}