package com.qaprosoft.carina.demo.mobile.gui.calculator.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CalcMainPageBase extends AbstractPage {
    public CalcMainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int multiply(int a, int b);
}
