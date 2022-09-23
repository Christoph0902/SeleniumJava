import com.github.javafaker.Faker;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {

    @Steps(shared = true)
    protected UserSteps step;

    @Managed(driver = "chrome")
    WebDriver browser;

    protected static Faker dataGenerator = new Faker();

    @BeforeEach
    public void setup() {
        step.userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanUp() {
        step.userClosesTodoMVCApp();
    }
}
