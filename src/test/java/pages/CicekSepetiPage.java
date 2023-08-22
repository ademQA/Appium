package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CicekSepetiPage {

    public CicekSepetiPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }
    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/currentPrice")
    public WebElement fiyat;

    @FindBy(xpath = "(//*[@class='androidx.appcompat.widget.LinearLayoutCompat'])[5]")
    public WebElement dorduncuSatirdakiUrun;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/addCart")
    public WebElement siparisVer;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/search")
    public WebElement mahalleAdres;

    @FindBy(id = "android:id/button1")
    public WebElement tamamButonu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement ilkAdresBileseni;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/apply")
    public WebElement kaydet;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/goOn")
    public WebElement devamEt;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Üye Ol\"]")
    public WebElement uyeOl;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/email")
    public WebElement email;


    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/password")
    public WebElement password;

    @FindBy(id = "com.ciceksepeti.ciceksepeti:id/name")
    public WebElement name;









}