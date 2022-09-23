
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class CreateTaskTests extends BaseSetup {

    @Test
    public void userCanAddTodo() {
        step.userAddsANewTodo();
        step.userChecksIfTodoIsCreated();
    }

//    @Test
//    public void userWaitForStopTodo() {
//        step.waitUntilSTOPTodo();
//    }

}
