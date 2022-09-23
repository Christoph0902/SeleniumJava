package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class NewTodoInput extends PageObject {

    private static final By NEW_TODO_INPUT = By.cssSelector(".new-todo");


    @Step
    public void createNewTodo(String todoName) {
        var newTodoInput = find(NEW_TODO_INPUT);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.RETURN);
    }
}
