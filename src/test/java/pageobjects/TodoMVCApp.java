package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class TodoMVCApp extends PageObject {

    private static final String TODOMVC_URL = "https://todomvc.com/examples/jquery/#/all";

    @Step
    public void openTodoMVC() {
        getDriver().get(TODOMVC_URL);
    }

    @Step
    public void closeTodoMVC() {
        getDriver().close();
    }
}
