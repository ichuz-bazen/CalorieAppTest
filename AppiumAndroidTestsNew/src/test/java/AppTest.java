import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

  public class AppTest {
    static AppiumDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        /*
        This test will open the lifesum App and prints the food item which is displayed randomly and
        validate whether a string value is displayed and also verifies the text 'calories per serving' is displayed or not
        For the assert command to work ,please update following settings.(There would be similar options in eclipse as well)
        Test will also validate a positive number greater than 0 is displayed for calorie information for each food product.
        IntelliJ IDEA:
         Go to Run > Edit Configurations.
         Select your run configuration for the class you want to run with assertions.
         In the VM options field, add -ea.
         Click Apply and then run the test script.

         */
        openMobileApp();

        String textValue = driver.findElement(By.xpath("//*[@resource-id=\"com.alpersevindik.lifesum:id/calorieValue\"]")).getText();
       //convert calorie string value to int
        int Calorienumber = Integer.parseInt(textValue);
        System.out.println("Converted Integer: " + Calorienumber);
        //validate calorie value displayed is greater than 0 and is a positive value
        assert Calorienumber > 0;


        WebElement element= driver.findElement(By.className("android.widget.TextView"));
        String text2=driver.findElement(By.xpath("//android.widget.TextView[@text='Calories per serving']")).getText();

        String foodProdName= element.getText();
        String expectedText= "Calories per serving";
        System.out.println(element.getText());
        System.out.println(text2);
        System.out.println(textValue);


     /*
     assert condition to validate whether the displayed text is a string for the food product displayed
     Assert condition to validate the text displayed is as per expected text for calories per serving
     */
        assert text2.equals(expectedText);
        assert !foodProdName.isEmpty();


    }


    public static void  openMobileApp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName",  "OnePlus 10R 5G");
        cap.setCapability("udid","X8HYW8HERSGIHMIZ");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion","14");
        cap.setCapability("automationName","uiAutomator2");
        cap.setCapability("appPackage","com.alpersevindik.lifesum");
        cap.setCapability("appActivity","com.alpersevindik.lifesum.ui.FoodActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver =new AppiumDriver(url,cap);

        System.out.println("Lifesum Application Started");



    }

    public void tapActionValidation() {

        //This method will tap on the device once and validate that tap has

        driver.findElement(By.id("//android.widget.TextView[@resource-id=\"com.alpersevindik.lifesum:id/calorieValue\"]")).click();

    }

}
