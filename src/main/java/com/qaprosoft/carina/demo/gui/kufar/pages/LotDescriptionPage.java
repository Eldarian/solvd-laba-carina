package com.qaprosoft.carina.demo.gui.kufar.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LotDescriptionPage extends AbstractPage {
    public LotDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@data-name='av_title']")
    private ExtendedWebElement lotLabel;


    public String getLotLabelText() {
        return lotLabel.getText();
    }
}
