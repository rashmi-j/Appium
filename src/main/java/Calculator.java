import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator {

    static AppiumDriver<MobileElement> driver;   //imports from java_client dependency
    static URL url;
    static DesiredCapabilities cap;

    public static void main(String[] args)
    {
        try
        {
            openCalculator();
        } catch (Exception exp)
        {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.getStackTrace();
        }

    }
    public static void openCalculator() throws  Exception
    {

        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }


        cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Moto G4 Plus");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1");
        cap.setCapability("appPackage", "com.android.calculator2");/*to know this info
        download apk-info app from that select calculator app and get the info*/
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        /*cap.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");*/
        /*cap.setCapability("appActivity", "com.android.calculator2.Licenses");*/
        /*cap.setCapability("appActivity", "com.google.android.gms.common.api.GoogleApiActivity");*/




        driver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("Application started..........");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        MobileElement num1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        MobileElement num2 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement action = driver.findElement(By.id("plus"));
        MobileElement Result = driver.findElement(By.id("com.google.android.calculator:id/result"));
        //MobileElement search = driver.findElement(By.id("com.vikatanapp.staging:id/action_search"));
        num1.click();
        num2.click();
        action.click();
        System.out.println(Result.getText());
        //search.click();

    }
}

