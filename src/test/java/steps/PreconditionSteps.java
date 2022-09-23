package steps;

import net.thucydides.core.annotations.Steps;

public class PreconditionSteps {

    @Steps(shared = true)
    UserSteps steps;

    public void userHasCompletedTask() {
        steps.userAddsANewTodo();
        steps.userCompletesTodo();
    }
}
