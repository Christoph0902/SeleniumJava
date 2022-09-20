
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.UserSteps;

public class CreateTaskTests {

    UserSteps steps = new UserSteps();

    @BeforeEach
    public void setUp() {
        steps.openBrowser();
    }

    @AfterEach
    public void cleanUp() {
        steps.closeBrowser();
    }


    @Test
    public void userCanAddTodo() {
        var todoName = "To jest moje lepsze zadanie";
        steps.userOpensTodoMVCApp();
        steps.userAdsNewTodo(todoName);
        steps.userChecksIfTodoIsCreated(todoName);

    }

    @Test
    public void userCanCompleteTodo() {
        var todoName = "Ten task jest zakończony";
        steps.userOpensTodoMVCApp();
        steps.userAdsNewTodo(todoName);
        steps.userMarksTodoAsDone(todoName);
        steps.userChecksIfTodoIsMarkedAsCompleted();
        steps.userChecksIfTodoIsNotActive(todoName);
        steps.userChecksIfTodoIsCompleted(todoName);
    }


}
