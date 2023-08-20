package tests.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CicekSepetiPage;
import utils.Driver;
import utils.ReusableMethods;

public class CicekSepetiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    TouchAction action = new TouchAction<>(driver);
    CicekSepetiPage cicekSepetiPage = new CicekSepetiPage();

    @Test
    public void cicekSepetiTest() throws InterruptedException {
        //  1.Uygulamanın yüklendiğini doğrulayın
        Assert.assertTrue(driver.isAppInstalled("com.ciceksepeti.ciceksepeti"));
        Thread.sleep(1000);

        //  2.Çiçek ve yenilebilir çiçek bölümünü seçin
        ReusableMethods.koordinatTiklama(300, 750, 1000);

        //  3.İçimden Geldi butonunu tıklayınız
        ReusableMethods.koordinatTiklama(900, 500, 1000);

        //  4.Filtrenin sağında bulunan Sırala Butonunu tıklayınız
        ReusableMethods.koordinatTiklama(950, 250, 1000);

        //  5.Ençok Değerlendirilenler butonuna basınız.
        ReusableMethods.koordinatTiklama(90, 1600, 1000);

        //  6.Ekranı yukarı kaydırarak 4.Satırdaki ürünü seçiniz
        ReusableMethods.screenScrollDown(500);
        cicekSepetiPage.dorduncuSatirdakiUrun.click();
       // ReusableMethods.koordinatTiklama(300, 800, 1000);


        // 7.Ürün fiyatının 1000 TL' den az olduğunu doğrulayın
        String fiyat=cicekSepetiPage.fiyat.getText();
        System.out.println(fiyat);
        fiyat=fiyat.replaceAll("[^\\d,]","");
        fiyat=fiyat.replaceAll(",",".");
        System.out.println(fiyat);
       // int sonFiyat= Integer.parseInt(fiyat);
       // System.out.println(sonFiyat);

        //  8.Sipariş ver Butonunu tıklayınız
        cicekSepetiPage.siparisVer.click();

        //  9. Adres bölümüne Mahallenizi girip uygun Adresi seçiniz
        cicekSepetiPage.mahalleAdres.sendKeys("Tatlıkuyu Mahallesi");
        ReusableMethods.koordinatTiklama(325,660,1000);

        //  10.Seçilen adres gönderim için uygun değilse tamam butonuna basınız
        cicekSepetiPage.tamamButonu.click();





    }


}
