import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import steps.PreconditionSteps;

import java.util.List;

public class CompleteTaskTests extends BaseSetup{

    @Steps
    PreconditionSteps preconditions;

    @Test
    public void userCanCompleteTheTodo() {
        preconditions.userHasCompletedTask();
        step.userChecksIfTodoIsMarkedAsCompleted();
    }

    @Test
    public void completedTaskIsFilteredOutOnActiveFilter() {
        preconditions.userHasCompletedTask();
        step.userChecksIfCompletedTaskIsNotOnActiveTab();
    }

    @Test
    public void completedTaskInOnCompletedFilter() {
        preconditions.userHasCompletedTask();
        step.userChecksIfCompletedTaskIsOnCompletedTab();
    }

    @Test
    public void userCanCompleteTHE_ONE() throws InterruptedException {
        List<String> todos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsTodos(todos);
        step.userAddsANewTodo("THE ONE");
        todos = dataGenerator.lorem().sentences(dataGenerator.number().numberBetween(0, 4));
        step.userAddsTodos(todos);
        step.userCompletesTodo("THE ONE");
        step.userChecksIfTodoIsMarkedAsCompleted("THE ONE");
        Thread.sleep(2000);
    }
}
