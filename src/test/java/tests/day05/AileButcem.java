package tests.day05;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AileButcesiPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

public class AileButcem {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AileButcesiPage aileButcesiPage = new AileButcesiPage();

    @Test
    public void aileButcesiTest() throws InterruptedException {
        Assert.assertTrue(driver.isAppInstalled("com.ailebutcem"));
//ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin
        for (int i = 1; i <= 7; i++) {
            TouchAction action = new TouchAction<>(driver);
            action.press(PointOption.point(940, 800))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(165, 800))
                    .release()
                    .perform();
        }
// mail ve password bilgilerini girerek kullanici bilgileriyle giris yapin
        aileButcesiPage.GirisButton.click();
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey(ConfigReader.getProperty("mail"));
        } else {
            driver.findElementByXPath("//*[@text='E-mail Adresi']").sendKeys(ConfigReader.getProperty("mail"));
        }
        Thread.sleep(1000);
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey(ConfigReader.getProperty("mail"));
        } else {
            driver.findElementByXPath("//*[@text='Şifre']").sendKeys(ConfigReader.getProperty("sifre"));
        }
        driver.findElementByXPath("//*[@text='Giriş Yap']").click();
        Thread.sleep(10000);
        // uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin
        driver.findElementByXPath("(//*[@class='android.widget.ImageView'])[1]").click();
        AndroidElement email = driver.findElementByXPath("//*[@text='testfort108@gmail.com']");
        Assert.assertTrue(email.isDisplayed());
        // sol kisimdaki menuden hesabim bolumune gidin
        ReusableMethods.koordinatTiklama(371, 778, 500);
        AndroidElement nameBox = driver.findElementByXPath("(//*[@class='android.widget.EditText'])[1]");
        nameBox.clear();
        nameBox.sendKeys("isa");
        AndroidElement surnameBox = driver.findElementByXPath("(//*[@class='android.widget.EditText'])[2]");
        surnameBox.clear();
        surnameBox.sendKeys("Avcı");
        AndroidElement adres = driver.findElementByXPath("(//*[@class='android.widget.EditText'])[3]");
        adres.clear();
        adres.sendKeys("Tokatt");
        ReusableMethods.koordinatTiklama(455, 1241, 500);
        driver.findElementByXPath("//*[@text='Erkek']").click();
        AndroidElement yas = driver.findElementByXPath("(//*[@class='android.widget.EditText'])[4]");
        yas.clear();
        yas.sendKeys("45");
        AndroidElement meslek = driver.findElementByXPath("(//*[@class='android.widget.EditText'])[5]");
        meslek.clear();
        meslek.sendKeys("QA Tester1");
        // hesabim sayfasindaki bilgileri degistirerek degisikleri kaydedin
        ReusableMethods.koordinatTiklama(455, 1692, 500);
        // ardindan degisiklerin yapildigini dogrulayin
        AndroidElement successUpdate = driver.findElementByXPath("//*[@text='Değişiklikler başarıyla kaydedildi.']");
        Assert.assertTrue(successUpdate.isDisplayed());
        System.out.println();
    }
}