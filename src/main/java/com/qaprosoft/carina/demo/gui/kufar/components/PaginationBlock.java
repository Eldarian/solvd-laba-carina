package com.qaprosoft.carina.demo.gui.kufar.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PaginationBlock extends AbstractUIObject {

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

    public PaginationBlock(WebDriver driver) {
        super(driver);
    }

    public PaginationBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isNextPageButtonActive() {
        return nextPageButton.isClickable();
    }

    public KufarHomePage openNextPage() {
        //if(isNextPageButtonActive()) {
            nextPageButton.click();
        //}
        return new KufarHomePage(getDriver());
    }

    public KufarHomePage openPreviousPage() {
        previousPageButton.click();
        return new KufarHomePage(getDriver());
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