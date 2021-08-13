package com.qaprosoft.carina.demo.gui.kufar.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class LotItem extends AbstractUIObject {
    public LotItem(WebDriver driver) {
        super(driver);
    }

    public LotItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
