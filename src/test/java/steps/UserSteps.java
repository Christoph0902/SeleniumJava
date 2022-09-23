package steps;

import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pageobjects.NewTodoInput;
import pageobjects.TodoFilters;
import pageobjects.TodoMVCApp;
import pageobjects.TodosList;

import java.util.List;


public class UserSteps {



    @Steps
    NewTodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoFilters filters;

    @Steps
    TodoMVCApp app;

    private String todoName;

    private static Faker dataGenerator = new Faker();

    @Step
    public void userChecksIfCompletedTaskIsOnCompletedTab() {
        userChecksIfCompletedTaskIsOnCompletedTab(this.todoName);
    }

    @Step
    public void userChecksIfCompletedTaskIsOnCompletedTab(String todoName) {
        filters.goToCompletedTab();
        todosList.checkIfTodoIsListed(todoName);
    }

    @Step
    public void userChecksIfCompletedTaskIsNotOnActiveTab() {
        userChecksIfCompletedTaskIsNotOnActiveTab(this.todoName);
    }
    @Step
    public void userChecksIfCompletedTaskIsNotOnActiveTab(String todoName) {
        filters.goToActiveTab();
        todosList.checkIfTodoIsNotListed(todoName);
    }

    @Step
    public void userChecksIfTodoIsMarkedAsCompleted() {
        userChecksIfTodoIsMarkedAsCompleted(this.todoName);
    }
    @Step
    public void userChecksIfTodoIsMarkedAsCompleted(String todoName) {
        todosList.checkIfTodoCompleted(todoName);
    }

    @Step
    public void userCompletesTodo() {
        userCompletesTodo(this.todoName);
    }

    @Step
    public void userCompletesTodo(String todoName) {
        todosList.completeTodo(todoName);
    }

    @Step
    public void userChecksIfTodoIsCreated() {
        userChecksIfTodoIsCreated(this.todoName);
    }

    @Step
    public void userChecksIfTodoIsCreated(String todoName) {
        todosList.checkIfTodoIsListed(todoName);
    }

    @Step
    public void userAddsANewTodo() {
        this.todoName = dataGenerator.dragonBall().character();
        userAddsANewTodo(this.todoName);
    }

    @Step
    public void userAddsANewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }

    @Step
    public void userOpensTodoMVCApp() {
        app.openTodoMVC();
    }

    @Step
    public void userClosesTodoMVCApp() {
        app.closeTodoMVC();
    }

    @Step
    public void userAddsTodos(List<String> todos) {
        for (String todo : todos) {
            userAddsANewTodo(todo);
        }
    }

    public void waitUntilSTOPTodo() {
        todosList.waitForSTOP();
    }
}
