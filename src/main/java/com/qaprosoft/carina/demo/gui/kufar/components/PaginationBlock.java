package com.qaprosoft.carina.demo.gui.kufar.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PaginationBlock extends AbstractUIObject {

    @FindBy(xpath = "./*[last()]")
    private ExtendedWebElement lastActivePaginationButton;

    @FindBy(xpath = "./span[text() and not(text()='...')]")
    private ExtendedWebElement currentPageSpan;

    public PaginationBlock(WebDriver driver) {
        super(driver);
    }

    public PaginationBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isNextPageButtonActive() {
        return lastActivePaginationButton.isClickable();
    }

    public KufarHomePage openNextPage() {
        //if(isNextPageButtonActive()) {
            lastActivePaginationButton.click();
        //}
        return new KufarHomePage(driver);
    }

    public int getCurrentPageIndex() {
        return Integer.parseInt(currentPageSpan.getText());
    }
}
