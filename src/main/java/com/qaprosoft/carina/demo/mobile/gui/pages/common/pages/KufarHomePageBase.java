package com.qaprosoft.carina.demo.mobile.gui.pages.common.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.LotItemBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.PaginationBlockBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.RegionSelectionMenuBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarHomePageBase extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-name='listings']/article/div/article/a")
    private List<LotItemBase> lotItems;

    @FindBy(xpath = "//div[@id='portal']//descendant::img[@alt='close']")
    private ExtendedWebElement closePopupMessageButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[2]//button[@id='cancel']")
    private ExtendedWebElement closeSubscribePopupButton;

    @FindBy(xpath = "//div[@data-cy]")
    private PaginationBlockBase paginationBlock;

    @FindBy(xpath = "//div[@id='header']/div[1]/div[3]//button[span/img]")
    private ExtendedWebElement regionSelectionButton;

    @FindBy(xpath = "//div[@id='header']//span[text()='Ваш регион' or text()='Ваш рэгіён']/..")
    private RegionSelectionMenuBase regionSelectionMenu;

    @FindBy(xpath = "//div/a/span[text()='Компьютерная техника']/parent::a")
    private List<ExtendedWebElement> computersCategoryLink;

    @FindBy(xpath = "//h1")
    private ExtendedWebElement pageHeader;

    @FindBy(xpath = "//span[text()='Фильтры']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//select[@name='sort']")
    private ExtendedWebElement sortSelector;

    @FindBy(xpath = "//button/img[@alt='globe']/..")
    private ExtendedWebElement languageButton;

    public KufarHomePageBase(WebDriver driver) {
        super(driver);
    }

    public LotDescriptionPageBase openFirstLot() {
        return lotItems.get(0).openDescriptionPage();
    }

    public void closePopupMessage() {
        closePopupMessageButton.click();
    }

    public void closeSubscribePopup() {
        closeSubscribePopupButton.click();
    }

    public List<LotItemBase> getLotItems() {
        return lotItems;
    }

    public PaginationBlockBase getPaginationBlock() {
        return paginationBlock;
    }

    public RegionSelectionMenuBase openRegionSelectionMenu() {
        regionSelectionButton.click();
        return regionSelectionMenu;
    }

    public String getSelectedRegionLabel() {
        return regionSelectionButton.findExtendedWebElement(By.xpath("./span/span")).getText();
    }


    public void openComputersCategory() {
        computersCategoryLink.get(0).click(); //TODO find more eloquent way
    }

    public String getPageHeaderText() {
        return pageHeader.getText();
    }

    public ExtendedWebElement getFilterButton() {
        return filterButton;
    }

    public void selectPriceSortByDescending() {
        sortSelector.select("По цене ↓");
    }

    public void switchLanguage() {
        languageButton.click();
    }
}
