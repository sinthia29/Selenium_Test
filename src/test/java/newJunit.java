import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class newJunit {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headed");
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void getTitle() {
        driver.get("https://demoqa.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("ToolsQa"));
    }

    @Test
    public void checkIfElementExists() {
        driver.get("https://demoqa.com/");
        boolean status = driver.findElement(By.className("banner-image")).isDisplayed();
        Assert.assertTrue(status);

    }


    @Test
    public void clickButton() {
        driver.get("https://demoqa.com/buttons");
        WebElement dblClickBtnElement = driver.findElement(By.id("doubleClickBtn"));
        WebElement rgtClickBtnElement = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(dblClickBtnElement).perform();
        actions.contextClick(rgtClickBtnElement).perform();
    }
}
