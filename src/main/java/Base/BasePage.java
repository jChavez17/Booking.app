package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }
/*
    WebDriverWait wait = new WebDriverWait(AppDriver, Duration.ofSeconds(30));

    protected WebElement waitForEl(By byLocator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    protected WebElement getEl(By byLocator) {
        return AppDriver.findElement(byLocator);
    }

    protected List<WebElement> getEls(By byLocator) {
        return AppDriver.findElements(byLocator);
    }

    protected void click(By byLocator) {
        getEl(byLocator).click();
    }

    protected void type(By byLocator, String text) {
        getEl(byLocator).sendKeys(text);
    }

    protected void waitNtype(By byLocator, String text) {
        waitForEl(byLocator);
        getEl(byLocator).clear();
        getEl(byLocator).sendKeys(text);
    }

    protected void waitNclick(By byLocator) {
        waitForEl(byLocator).click();
    }

    protected int size(By byLocator) {
        return getEls(byLocator).size();
    }

    protected int size(List<WebElement> els) {
        return els.size();
    }

    protected String getText(By byLocator) {
        String str = "";
        str = getEl(byLocator).getText();
        return str;
    }

    protected String getAttribute(By byLocator, String attr) {
        return waitForEl(byLocator).getAttribute(attr);
    }

    protected boolean isListItemsContain(List<WebElement> items, String text) {
        boolean flag = false;

        for (WebElement el : items) {
            if (el.getText().contains(text)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected boolean isTextMatches(WebElement el, String text) {
        return el.getText().equalsIgnoreCase(text);
    }

    protected boolean isTextContains(WebElement el, String text) {
        return el.getText().contains(text);
    }

    protected Set<String> getContexts() {
        return ((SupportsContextSwitching) AppDriver).getContextHandles();
    }

    protected String getCurrentContext() {
        return ((SupportsContextSwitching) AppDriver).getContext();
    }

    private Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.findElement(byLocator));
    }

    private Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public void selectDropDownByOption(WebElement el, String option) {
        getDropDownElement(el).selectByVisibleText(option);
    }

    protected List<WebElement> getDropDownOptions(WebElement el) {
        return getDropDownElement(el).getOptions();
    }

    protected List<WebElement> getDropDownAllSelectedOptions(WebElement el) {
        return getDropDownElement(el).getAllSelectedOptions();
    }

    protected WebElement getDropDownSelectedOption(WebElement el) {
        return getDropDownElement(el).getFirstSelectedOption();
    }

    protected boolean isDropDownItemscontain(WebElement element, String text) {
        boolean flag = false;
        List<WebElement> els = getDropDownElement(element).getOptions();
        for (WebElement el : els) {
            if (el.getText().contains(text)) {
                flag = true;
                break;
            }
        }
        return flag;
    }*/

    public WebElement find(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element);
    }

    public void submit(By element) throws Exception {
        try {
            find(element).submit();

        } catch (Exception e) {
            throw new Exception("No se pudo submitear sobre el elemento:" + element);
        }
    }

    public void sendKeys(By element, String inputText) throws Exception {
        try {
            find(element).sendKeys(inputText);
        } catch (Exception e) {
            throw new Exception("No se pudo ingresar el texto:" + element);
        }
    }

    public void clear(By element) throws Exception {
        try {
            find(element).clear();
        } catch (Exception e) {
            throw new Exception("No se pudo limpiar el texto:" + element);
        }
    }

    public void click(By element) throws Exception {
        try {
            find(element).click();
        } catch (Exception e) {
            throw new Exception("No se pudo clickear sobre el elemento:" + element);
        }
    }

    public String getPageTitle() throws Exception {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el titulo de la pagina");
        }
    }

    public String getUrl() throws Exception {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener la URL");
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public boolean isDisplayed(By element) throws Exception {
        try {
            driver.findElement(element).isDisplayed();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By element) throws Exception {
        try {
            return find(element).getText();

        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento:" + element);
        }

    }

    public void enterValue(By element) throws Exception {
        try {
            find(element).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new Exception("No se pudo ingresar el texto:" + element);
        }
    }

    public void selectVisibleTextCombo(By element, String texto) throws Exception {
        try {
            new Select(find(element)).selectByVisibleText(texto);
        } catch (Exception e) {
            throw new Exception("No se pudo selecionar el valor del combo:" + element);
        }
    }

    public void iframeName(By element) throws Exception {
        try {
            driver.switchTo().frame(find(element));
        } catch (Exception e) {
            throw new Exception("No se pudo ir al iFrame" + element);
        }
    }

    public void iframeNameAll() throws Exception {
        try {
            driver.switchTo().frame(find(By.cssSelector("iframe[class='ng-isolate-scope']")));
        } catch (Exception e) {
            throw new Exception("No se pudo ir al iFrame");
        }
    }

    public void iframeDefault() throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            throw new Exception("No se pudo salir del iframe");
        }
    }

    public void parentFrame() throws Exception {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            throw new Exception("No se pudo ir al parent Frame");
        }
    }

    public void iframeIndex(int index) throws Exception {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            throw new Exception("No se pudo ir al Frame" + index);
        }
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public WebElement wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void implicitWait(int time) throws Exception {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
