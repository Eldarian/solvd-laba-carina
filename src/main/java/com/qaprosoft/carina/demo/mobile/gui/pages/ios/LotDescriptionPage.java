package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.LotDescriptionPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LotDescriptionPageBase.class)
public class LotDescriptionPage extends LotDescriptionPageBase {
    public LotDescriptionPage(WebDriver driver) {
        super(driver);
    }

}
