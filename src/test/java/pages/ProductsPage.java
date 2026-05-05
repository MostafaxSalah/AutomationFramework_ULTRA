package pages;

import org.openqa.selenium.By;
import utils.ElementActions;
import utils.WaitUtils;

public class ProductsPage {

    By add = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By viewCart = By.xpath("//u[text()='View Cart']");
    By addedPopup = By.xpath("//*[contains(text(),'Added!')]");

    public void addProduct() {
        ElementActions.click(add);
        WaitUtils.waitVisible(addedPopup);
        WaitUtils.waitForPageLoad();
        ElementActions.click(viewCart);
    }
}