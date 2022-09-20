import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

    @Test
    public void browserPuppeteer() throws InterruptedException {
        var browser = new ChromeDriver();
        browser.get("http://google.pl");
        browser.manage().window().maximize();
        Thread.sleep(2000);
        browser.close();


    }
}
