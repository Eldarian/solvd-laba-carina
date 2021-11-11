package com.qaprosoft.carina.demo.gui.kufar.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.kufar.pages.LotDescriptionPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LotItem extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "./*")
    private ExtendedWebElement lotLink;

    @FindBy(xpath = ".//h3")
    private ExtendedWebElement lotLabel;

    @FindBy(xpath = ".//span[preceding-sibling::img]")
    private ExtendedWebElement regionLabel;

    @FindBy(xpath = ".//span[contains(text(), ' р.')]") //TODO predict no price сase
    private ExtendedWebElement priceSpan;

    public LotItem(WebDriver driver) {
        super(driver);
    }

    public LotItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LotDescriptionPage openlotDescriptionPage() {
        lotLink.click();
        return new LotDescriptionPage(driver);
    }

    public String getLotLabel() {
        return lotLabel.getText();
    }

    public LotDescriptionPage openDescriptionPage() {
        lotLink.click();
        String originalWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return new LotDescriptionPage(getDriver());
    }

    public String getRegionLabelText() {
        return regionLabel.getText();
    }

    public int getPrice() {
        String s = priceSpan.getText();
        if (s.equals("Бесплатно")) return 0;
        s = s.replaceAll("\\s+", "").replaceAll("р.", "");
        return Integer.parseInt(s);
    }
}
