package com.qaprosoft.carina.demo.mobile.gui.menuapp.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuMainPageBase extends AbstractPage {
    public MenuMainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addEntry();
    public abstract void refresh();
    public abstract String getBreakfastDish();
}
