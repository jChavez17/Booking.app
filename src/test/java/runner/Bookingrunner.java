package runner;

import Base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class calculadora2 extends BasePage {
    public calculadora2(AndroidDriver driver) {
        super(driver);
    }

    private static AndroidDriver driver;
    By cerrarSingIn = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    By buscarDestino = By.xpath("//android.widget.Button[@content-desc=\"Enter your destination\"]");
    By ingresarDestino = By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content");
    By seleccionarCusco = By.xpath("(//android.widget.TextView[@resource-id=\"com.booking:id/view_disambiguation_destination_title\"])[1]");
    By checkIn = By.xpath("//android.view.View[@content-desc=\"08 May 2024\"]");
    By checkOut = By.xpath("//android.view.View[@content-desc=\"14 May 2024\"]");
    By btnSelectDates = By.id("com.booking:id/facet_date_picker_confirm");
    By seleccionarHabitacion = By.xpath("//android.widget.Button[@content-desc=\"1 room, 2 adults, 0 children\"]");
    By agregarNino = By.xpath("(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[3]");
    By seleccionarEdad = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/group_config_children_ages_recycler_view\"]/android.widget.FrameLayout");
    By agregarEdad = By.xpath("//android.widget.Button[@text=\"5 years old\"]");
    By btnApplyEdad = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    By btnApplyNino = By.id("com.booking:id/group_config_apply_button");
    By btnSeach = By.xpath("(//android.widget.TextView[@text=\"Search\"])[1]");
    //By seleccionarHotel = By.xpath("(//android.view.View[@resource-id=\"com.booking:id/photo\"])[2]");
    By btnSelectRooms = By.id("com.booking:id/select_room_cta");
    By btnReserveTheseOptions = By.id("com.booking:id/recommended_block_reserve_button");

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformversion", "11");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("udid", "emulator-5554");  //Mi emulador version 30
        capabilities.setCapability("udid", "eezh5p5hj7wgd699"); //Modelo de mi cel Redmi Note 8 PROD
        capabilities.setCapability("app", "D:\\booking.com.apk");
        //capabilities.setCapability("appPackage", "com.miui.calculator");
        //capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
        //capabilities.setCapability("appPackage", "com.booking");
        //capabilities.setCapability("appActivity", "com.booking.appindex.presentation.activity.SearchActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        Thread.sleep(15000);
        driver = new AndroidDriver(url, capabilities);
        System.out.println("Aplicación inicaciada");
        Thread.sleep(3000);
        calculadora2 app = new calculadora2(driver);
        app.igresarDestino("Cusco");
        app.seleccionarfechas();
        app.ingresarNinio();
        app.realizarBusqueda();
        app.seleccionarHabitacion();
        app.tearDown();

    }

    public void igresarDestino(String destino) throws Exception {
        click(cerrarSingIn);
        Thread.sleep(6000);
        clickAtCoordinates(600, 368);
        click(buscarDestino);
        sendKeys(ingresarDestino, destino);
        Thread.sleep(1000);
        click(seleccionarCusco);
        Thread.sleep(2000);
    }

    public void seleccionarfechas() throws Exception {
        click(checkIn);
        click(checkOut);
        click(btnSelectDates);
        Thread.sleep(2000);
    }

    public void ingresarNinio() throws Exception {
        click(seleccionarHabitacion);
        click(agregarNino);
        click(seleccionarEdad);
        scrollToElement(agregarEdad,0.2);
        click(agregarEdad);
        Thread.sleep(2000);
        click(btnApplyEdad);
        click(btnApplyNino);
        Thread.sleep(2000);
    }
    public void realizarBusqueda() throws Exception {
        click(btnSeach);
        Thread.sleep(3000);

    }
    public void seleccionarHabitacion() throws Exception {
        clickAtCoordinates(224, 2150); //seleccionar la segunda opción
        click(btnSelectRooms);
        click(btnReserveTheseOptions);
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Aplicación Cerrada");
        }
    }
}
