package pages;

import org.openqa.selenium.By;
import utils.ElementActions;
import utils.WaitUtils;

public class CartPage {

    By checkout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public void checkout() {
        WaitUtils.waitForPageLoad();
        ElementActions.click(checkout);
    }
}