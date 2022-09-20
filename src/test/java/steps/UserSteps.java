package steps;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserSteps {

    private static final By NEW_TODO_INPUT = By.cssSelector(".new-todo");
    private static final By TODOS_LIST = By.cssSelector(".todo-list");
    private static final String TODOMVC_URL = "http://todomvc.com/examples/jquery/";
    private static final By TODO_CHECKBOX = By.cssSelector(".todo-list .toggle");
    private static final By ACTIVE_TODOS_BUTTON = By.cssSelector(".filters [href='#/active']");
    private static final By COMPLETED_TODOS_BUTTON = By.cssSelector(".filters [href='#/completed']");

    private WebDriver browser = new ChromeDriver();

    public void userOpensTodoMVCApp() {
        browser.get(TODOMVC_URL);
    }

    public void userAdsNewTodo(String todo) {
        WebElement input = browser.findElement(NEW_TODO_INPUT);
        input.sendKeys(todo);
        input.sendKeys(Keys.ENTER);
    }

    public void userChecksIfTodoIsCreated(String todoName) {
        var list = browser.findElement(TODOS_LIST);
        var todos = list.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.containsString(todoName));
    }

    public void userMarksTodoAsDone(String todoName) {
        var checkbox = browser.findElement(TODO_CHECKBOX);
        checkbox.click();
    }

    public void userChecksIfTodoIsMarkedAsCompleted() {
        var todo = browser.findElement(By.cssSelector(".todo-list li"));
        var classes = todo.getAttribute("class");
        MatcherAssert.assertThat("Todo is marked as completed", classes, Matchers.equalTo("completed"));

//        var completedTodos = browser.findElements(By.cssSelector(".completed"));


    }

    public void userChecksIfTodoIsNotActive(String todoName) {
        var activeTodos = browser.findElement(ACTIVE_TODOS_BUTTON);
        activeTodos.click();
        var list = browser.findElement(TODOS_LIST);
        var todoNames = list.getText();
        MatcherAssert.assertThat("Todo is not active", todoNames, Matchers.not(Matchers.equalTo(todoName)));
    }

    public void userChecksIfTodoIsCompleted(String todoName) {
        var completedTodos = browser.findElement(COMPLETED_TODOS_BUTTON);
        completedTodos.click();
        var list = browser.findElement(TODOS_LIST);
        var todoNames = list.getText();
        MatcherAssert.assertThat("Todo is completed", todoNames, (Matchers.containsString(todoName)));
    }

    public void openBrowser() {
        browser.get(TODOMVC_URL);
    }

    public void closeBrowser() {
        browser.close();
    }
}
