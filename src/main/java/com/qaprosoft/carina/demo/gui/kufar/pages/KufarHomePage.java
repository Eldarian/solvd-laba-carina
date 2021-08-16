package com.qaprosoft.carina.demo.gui.kufar.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.PaginationBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-name='listings']/article/div/a")
    private List<LotItem> lotItems;

    @FindBy(xpath = "//div[@id='portal']//descendant::img[@alt='close']")
    private ExtendedWebElement portalCloseButton;

    @FindBy(xpath = "//div[@data-cy]")
    private PaginationBlock paginationBlock;

    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    public void openFirstLot() {
        lotItems.get(0).openDescriptionPage();
    }

    public void closePortal() {
        portalCloseButton.click();
    }

    public List<LotItem> getLotItems() {
        return lotItems;
    }

    public PaginationBlock getPaginationBlock() {
        return paginationBlock;
    }
}
