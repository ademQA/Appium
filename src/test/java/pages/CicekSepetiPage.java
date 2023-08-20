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







}