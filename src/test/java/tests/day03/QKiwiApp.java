package tests.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;

public class QKiwiApp {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    TouchAction action = new TouchAction<>(driver);
    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void QKiwiAppTest() {
//1. uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
//2. uygulamanin basariyla acildigi dogrulanir
//3. misafir olarak devam et e tiklanir
//4. ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
//5. Trip type,one way olarak secilir
//6. kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
//7. kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
//8. varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
//9. gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
//10. search butonuna tiklanir
//11. en  ucuz ve aktarmasiz filtrelemeleri yapilir
//12. gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
//13. uygulamayi kapatalim

    }

}