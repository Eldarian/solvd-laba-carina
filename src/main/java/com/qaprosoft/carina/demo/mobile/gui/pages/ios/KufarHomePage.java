package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.LotDescriptionPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = KufarHomePageBase.class)
public class KufarHomePage extends KufarHomePageBase implements IMobileUtils {
    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='portal']//button")
    private ExtendedWebElement closePopupMessageButton;

    @FindBy(xpath = "//div[@data-name='listings']/article/div/article/a")
    private List<ExtendedWebElement> lotItems;

    @Override
    public void closePopupMessage() {
        /*if(closePopupMessageButton.isElementPresent()) {
            closePopupMessageButton.click();
        }*/
    }

    @Override
    public LotDescriptionPageBase openLot(int index) {
        tap(lotItems.get(index));
        return initPage(LotDescriptionPageBase.class);
    }
}
