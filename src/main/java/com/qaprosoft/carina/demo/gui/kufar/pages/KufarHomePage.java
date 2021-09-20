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
import java.nio.charset.StandardCharsets;
import java.util.List;

public class KufarHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-name='listings']/article/div/a")
    private List<LotItem> lotItems;

    @FindBy(xpath = "//div[@id='portal']//descendant::img[@alt='close']")
    private ExtendedWebElement closePopupMessageButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[2]//button[@id='cancel']")
    private ExtendedWebElement closeSubscribePopupButton;

    @FindBy(xpath = "//div[@data-cy]")
    private PaginationBlock paginationBlock;

    @FindBy(xpath = "//div[@id='header']/div[1]/div[3]//button[span/img]")
    private ExtendedWebElement regionSelectionButton;

    @FindBy(xpath = "//div[@id='header']//span[text()='Ваш регион' or text()='Ваш рэгіён']/..")
    private RegionSelectionMenu regionSelectionMenu;

    @FindBy(xpath = "//span[text()='Компьютерная техника'][not(../img)]/parent::a")
    private ExtendedWebElement computersCategoryLink;

    @FindBy(xpath = "//h1")
    private ExtendedWebElement pageHeader;

    @FindBy(xpath = "//span[text()='Фильтры']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//select[@name='sort']")
    private ExtendedWebElement sortSelector;

    @FindBy(xpath = "//div[@id='main-content']/following-sibling::div//button")
    private ExtendedWebElement languageButton;

    @FindBy(xpath = "//div[@data-name='login_button']/button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//div[@data-name='login_submit']/button")
    private ExtendedWebElement submitAuthButton;

    @FindBy(xpath = "//div[@data-name='user_profile_pic']")
    private ExtendedWebElement userProfilePic;

    public KufarHomePage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        openLoginWindow();
        enterUserCredentials(email, password);
        confirmLogin();
    }

    public boolean isUserProfilePicPresent() {
        return userProfilePic.isElementPresent();
    }

    public void openLoginWindow() {
        loginButton.click();
    }

    public void enterUserCredentials(String email, String password) {
        emailField.type(email);
        passwordField.type(password);
    }


    public void confirmLogin() {
        submitAuthButton.click();
    }

    public LotDescriptionPage openFirstLot() {
        return lotItems.get(0).openDescriptionPage();
    }

    public void closePopupMessage() {
        closePopupMessageButton.click();
    }

    public void closeSubscribePopup() {
        closeSubscribePopupButton.click();
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

    public void selectPriceSortByDescending() {
        sortSelector.select("По цене ↓");
    }

    public void switchLanguage() {
        languageButton.click();
    }

    public boolean isFilterButtonPresent() {
        return filterButton.isPresent();
    }
}
