package day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamCom {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Eger ki kullandigimiz android surumu 6 veya ustuyse UiAutomator2 kullanilir

        //capabilities.setCapability(MobileCapabilityType.APP, "/Users/MACBOOKAIR/Desktop/AppiumTeam116/Apps/arabam.com_4.8.0_Apkpure.apk");

        capabilities.setCapability("appPackage", "com.dogan.arabam");
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {
        // driver.activateApp("com.dogan.arabam"); Bir uygulamayı aktif hale getirmek

        //uygulamanın başarılı bir şekilde yüklendiği doğrulanır
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));


        //1. Arabam kac para bolumune tiklayalim
        //driver.findElementById("com.dogan.arabam:id/tvMyCarDesc").click();
        driver.findElementByXPath("//*[@text='Arabam kaç para?']").click();

        //2. Aracimin fiyatini merak ediyorum bolumunetiklayalim
        // driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        //3. Wolkswagen markasini secelim
        Thread.sleep(3000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(535, 1726))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(535, 240))
                .release().perform();

        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        //4. yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();

        //5. model secimi yapalim
        driver.findElementByXPath("//*[@text='Passat']").click();

        //6. govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();

        //7. yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();

        //8. vites tipini secelim
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();

        //9. Versiyon secimi yapalim
        Thread.sleep(1000);
      action.press(PointOption.point(456,618))
              .release().perform();

        //10. aracin km bilgilerini girelim
        AndroidElement kmBox=driver.findElementById("com.dogan.arabam:id/et_km");
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("150000");
        }else {
            kmBox.sendKeys("100000");
        }

        driver.findElementByXPath("//*[@text='Devam']").click();
        //11. aracin rengini secelim
        driver.findElementByXPath("(//*[@class='android.widget.TextView'])[16]").click();


        //12. opsiyel donanim (varsa) seecelim
        driver.findElementByXPath("//*[@text='Devam']").click();

        //13. degisen bilgisi ekleyerek tramer kaydi belirtelim
        Thread.sleep(1000);
        action.press(PointOption.point(538,795)).release().perform();
        action.press(PointOption.point(233,1609)).release().perform();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Tramer kaydı yok']").click();

        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();
        //14. aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        Thread.sleep(1000);
        AndroidElement ortalamaFiyatSonucuLocate=driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortalamaSonuc=ortalamaFiyatSonucuLocate.getText();
        System.out.println(ortalamaSonuc);

        ortalamaSonuc=ortalamaSonuc.replaceAll("\\D","");
        System.out.println(ortalamaSonuc);

        Assert.assertTrue(Integer.parseInt(ortalamaSonuc)>500000);

        //15. uygulamayi kapatalim
        driver.closeApp();

    }
}
