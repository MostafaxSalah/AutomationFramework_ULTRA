package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        
        // إعدادات منع النوافذ المنبثقة ومدير كلمات المرور
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");

        // إعدادات التشغيل في الخلفية (مهمة جداً لخوادم GitHub Actions)
        options.addArguments("--headless=new"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--disable-gpu"); 

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // تمرير الخيارات إلى الـ Driver
        driver.set(new ChromeDriver(options));
        
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() { 
        return driver.get(); 
    }
    
    public static void quit() { 
        getDriver().quit(); 
        driver.remove(); 
    }
}