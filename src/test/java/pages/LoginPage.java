package pages;
import org.openqa.selenium.By;
import utils.DriverFactory;
public class LoginPage {
By loginBtn = By.linkText("Signup / Login");
By email = By.name("email");
By password = By.name("password");
By submit = By.xpath("//button[text()='Login']");
public void login(String u,String p){
DriverFactory.getDriver().findElement(loginBtn).click();
DriverFactory.getDriver().findElement(email).sendKeys(u);
DriverFactory.getDriver().findElement(password).sendKeys(p);
DriverFactory.getDriver().findElement(submit).click();
}}