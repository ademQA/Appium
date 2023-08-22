package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AileButcesiPage {
    public AileButcesiPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);

    }
    @FindBy(xpath = "//*[@text='Giriş Yap']")
    public WebElement GirisButton;

    @FindBy(xpath = "//*[@text='android.widget.EditText']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@text='Şifre']")
    public WebElement sifreBox;
}
