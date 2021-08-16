package com.qaprosoft.carina.demo.gui.kufar.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegionSelectionMenu extends AbstractUIObject {

    @FindBy(xpath = ".//select[@name='rgn']")
    private ExtendedWebElement regionSelector;

    @FindBy(xpath = ".//select[@name='ar']")
    private ExtendedWebElement townSelector;

    @FindBy(xpath = ".//button[text()='Выбрать' or text()='Выбраць']")
    private ExtendedWebElement confirmButton;

    public RegionSelectionMenu(WebDriver driver) {
        super(driver);
    }

    public RegionSelectionMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectRegion(int regionIndex) {

    }

    public void selectTown(int townIndex) {

    }

    public void confirmRegion() {
        
    }
}
