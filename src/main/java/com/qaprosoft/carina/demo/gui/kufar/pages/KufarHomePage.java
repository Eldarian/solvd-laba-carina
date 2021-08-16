package com.qaprosoft.carina.demo.gui.kufar.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class KufarHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//article/div/a[1]")
    private ExtendedWebElement lotFirst;

    @FindBy(xpath = "//article/div/a[1]/descendant::h3")
    private ExtendedWebElement lotFirstLabel;

    @FindBy(xpath = "//div[@id='portal']//descendant::img[@alt='close']")
    private ExtendedWebElement portalCloseButton;

    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstLot() {
        lotFirst.click();
    }

    public String getLotFirstLabel() {
        return lotFirstLabel.getText();
    }

    public void closePortal() {
        portalCloseButton.click();
    }
}
