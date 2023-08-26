package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class VatanBilgisayarPage {
    VatanBilgisayarPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }
}
