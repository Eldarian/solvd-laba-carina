package com.qaprosoft.carina.demo.mobile.gui.pages.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class PaginationBlockBase extends AbstractUIObject {

    Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "./*[last()]")
    private ExtendedWebElement nextPageButton;

    @FindBy(xpath = "./span[text() and not(text()='...')]")
    private ExtendedWebElement currentPageSpan;

    @FindBy(xpath = "./*[1]")
    private ExtendedWebElement previousPageButton;

    @FindBy(xpath = "./*[2]")
    private ExtendedWebElement firstPageButton;

    @FindBy(xpath = "./*[position() = last() - 1]")
    private ExtendedWebElement lastPageButton;

    public PaginationBlockBase(WebDriver driver) {
        super(driver);
    }

    public PaginationBlockBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isNextPageButtonActive() {
        LOGGER.debug("tag is {}", nextPageButton.getElement().getTagName());
        return nextPageButton.getElement().getTagName().equalsIgnoreCase("a");
    }

    public KufarHomePageBase openNextPage() {
        //if(isNextPageButtonActive()) {
            nextPageButton.click();
        //}
        return new KufarHomePageBase(getDriver());
    }

    public KufarHomePageBase openPreviousPage() {
        previousPageButton.click();
        return new KufarHomePageBase(getDriver());
    }

    public int getCurrentPageIndex() {
        return Integer.parseInt(currentPageSpan.getText());
    }

    public void openFirstPage() {
        if(firstPageButton.isClickable()) {
            firstPageButton.click();
        }
    }

    public void openThirdPage() {
        openFirstPage();
        pause(3);
        nextPageButton.click();
        pause(3);
        nextPageButton.click();
    }

    public void openLastPage() {
        lastPageButton.click();
    }

    public boolean isPreviousPageButtonActive() {
        return previousPageButton.isChecked();
    }
}