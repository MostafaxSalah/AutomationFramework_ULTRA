package base;

import org.testng.annotations.*;
import utils.DriverFactory;
import java.util.Properties;
import java.io.FileInputStream;

public class BaseTest {
    
    protected Properties prop;

    @BeforeMethod
    public void setup() throws Exception {
        DriverFactory.initDriver();
        prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config.properties"));
        DriverFactory.getDriver().get(prop.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        // عطلت زرار الاغلاق علشان يفضل المتصفح شغال بعد الاخ
        // DriverFactory.quit(); 
    }
}