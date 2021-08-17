package com.qaprosoft.carina.demo.gui.kufar.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.PaginationBlock;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import org.openqa.selenium.By;
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
    private ExtendedWebElement closePopupMessageButton;

    @FindBy(xpath = "//div[@data-cy]")
    private PaginationBlock paginationBlock;

    @FindBy(xpath = "//div[@id='header']/div[1]/div[3]//button[span/img]")
    private ExtendedWebElement regionSelectionButton;

    @FindBy(xpath = "//div[@id='header']//span[text()='Ваш регион' or text()='Ваш рэгіён']/..")
    private RegionSelectionMenu regionSelectionMenu;

    @FindBy(xpath = "//ul//span[text()='Компьютерная техника']/parent::a")
    private ExtendedWebElement computersCategoryLink;

    @FindBy(xpath = "//h1")
    private ExtendedWebElement pageHeader;

    @FindBy(xpath = "//span[text()='Фильтры']")
    private ExtendedWebElement filterButton;

    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    public void openFirstLot() {
        lotItems.get(0).openDescriptionPage();
    }

    public void closePopupMessage() {
        closePopupMessageButton.click();
    }

    public List<LotItem> getLotItems() {
        return lotItems;
    }

    public PaginationBlock getPaginationBlock() {
        return paginationBlock;
    }

    public RegionSelectionMenu openRegionSelectionMenu() {
        regionSelectionButton.click();
        return regionSelectionMenu;
    }

    public String getSelectedRegionLabel() {
        return regionSelectionButton.findExtendedWebElement(By.xpath("./span/span")).getText();
    }


    public void openComputersCategory() {
        computersCategoryLink.click();
    }

    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public ExtendedWebElement getFilterButton() {
        return filterButton;
    }
}
