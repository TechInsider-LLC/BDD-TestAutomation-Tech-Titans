package stepDefinitions;
<<<<<<< Updated upstream
=======

import io.cucumber.java.After;
import io.cucumber.java.Before;
>>>>>>> Stashed changes
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
<<<<<<< Updated upstream

    @After
    public void tearDown(){driver.quit();}


=======
    
    public static WebDriver getDriver(){
        return driver;
    }

    @After
    public void tearDown(){driver.quit();}
>>>>>>> Stashed changes
}

