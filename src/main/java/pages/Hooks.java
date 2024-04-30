package pages;


import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Hooks {

    private static WebDriver driver;
    private static int numberofCase = 0;
    private DriverManager driverManager;
    Scenario scenario;

    @Before ("@Login")
    public void setUp() {
        numberofCase++;
        System.out.println("Se esta ejecutando el escenario nro: " + numberofCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://login.qa.flex.redteam.com/#/login");
        driver.manage().window().maximize();
    }

    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        //driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        System.out.println("El escenario nro: " + numberofCase + " se ejecutó correctamente.");
        return driver;
    }

}
