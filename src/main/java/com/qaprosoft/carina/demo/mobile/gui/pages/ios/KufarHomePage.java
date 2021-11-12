package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = KufarHomePageBase.class)
public class KufarHomePage extends KufarHomePageBase {
    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='portal']//button")
    private ExtendedWebElement closePopupMessageButton;

    @Override
    public void closePopupMessage() {
        closePopupMessageButton.click();
    }
}
