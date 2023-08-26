package tests.day04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CicekSepetiPage;
import utils.ConfigReader;
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
        String fiyat = cicekSepetiPage.fiyat.getText();
        System.out.println(fiyat);
        fiyat = fiyat.replaceAll("[^\\d,]", "");
        fiyat = fiyat.replaceAll(",", ".");
        System.out.println(fiyat);
        double sonFiyat = Double.parseDouble(fiyat);
        System.out.println(sonFiyat);
        Assert.assertTrue(sonFiyat < 1000);

        //  8.Sipariş ver Butonunu tıklayınız
        cicekSepetiPage.siparisVer.click();

        //  9. Adres bölümüne Mahallenizi girip uygun Adresi seçiniz
        cicekSepetiPage.mahalleAdres.sendKeys("Tatlıkuyu Mahallesi");
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklama(389, 653, 1000);
        //cicekSepetiPage.ilkAdresBileseni.click();
        Thread.sleep(1000);


        //  10.Seçilen adres gönderim için uygun değilse tamam butonuna basınız
        //cicekSepetiPage.tamamButonu.click();
        ReusableMethods.koordinatTiklama(534, 1066, 1000);

        //  11.Seçilen adrese gönderilebilecek ürünlerden ilk çıkan sonucu seçiniz
        ReusableMethods.koordinatTiklama(267, 640, 1000);

        //  12.Sipariş ver butonunu tıklayınız
        cicekSepetiPage.siparisVer.click();

        //  13.Teslimat tarihinden en yakın tarihi  seçiniz
        ReusableMethods.koordinatTiklama(158, 393, 1000);

        //  14. Teslimat saati bölümünü tıklayıp 10:00-13:00 seçeneğini seçiniz
        ReusableMethods.koordinatTiklama(400, 732, 1000);
        ReusableMethods.koordinatTiklama(525, 1326, 1000);

        //  15. Kaydet Butonuna tıklayınız
        cicekSepetiPage.kaydet.click();

        //  16.Devam  et butonuna tıklayınız.
        cicekSepetiPage.devamEt.click();

        //  17.Üye ol butonunu tıklayınız
        cicekSepetiPage.uyeOl.click();
        Thread.sleep(1000);

        //  18.E-mail butonunu tıklayınız
        cicekSepetiPage.email.click();
        cicekSepetiPage.email.sendKeys(ConfigReader.getProperty("mail"));

        //  19.Password değerini giriniz.
        cicekSepetiPage.password.click();
        cicekSepetiPage.password.sendKeys(ConfigReader.getProperty("sifre"));

        //  20.Ad soyad kısmına isim giriniz
        cicekSepetiPage.name.click();
        cicekSepetiPage.name.sendKeys(ConfigReader.getProperty("name"));
        ReusableMethods.koordinatTiklama(986, 1706, 1000);

        //  21. Okudum kabul ediyorum kutusunu seçip üye ol butonuna tıklayınız
        ReusableMethods.koordinatTiklama(99, 1247, 1000);
        cicekSepetiPage.uyeOlSon.click();




    }


}
