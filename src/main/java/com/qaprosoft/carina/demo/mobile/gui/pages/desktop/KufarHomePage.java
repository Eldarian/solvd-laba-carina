package com.qaprosoft.carina.demo.mobile.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = KufarHomePageBase.class)
public class KufarHomePage extends KufarHomePageBase {
    public KufarHomePage(WebDriver driver) {
        super(driver);
    }
}
