package pageobjects;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TodoFilters extends PageObject {

    private static final By COMPLETED_FILTER = By.cssSelector(".filters [href='#/completed']");
    private static final By ACTIVE_FILTER = By.cssSelector(".filters [href='#/active']");

    public void goToActiveTab() {
        find(ACTIVE_FILTER).click();
    }

    public void goToCompletedTab() {
        find(COMPLETED_FILTER).click();
    }
}
