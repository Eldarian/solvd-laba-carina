package com.qaprosoft.carina.demo.mobile.gui.calculator.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.calculator.pages.common.CalcMainPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalcMainPageBase.class)
public class CalcMainPage extends CalcMainPageBase {
    public CalcMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.google.android.calculator:id/digit_2")
    private ExtendedWebElement twoButton;

    @ExtendedFindBy(accessibilityId = "multiply")
    private ExtendedWebElement multiplyButton;

    @ExtendedFindBy(accessibilityId = "equals")
    private ExtendedWebElement equalsButton;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private ExtendedWebElement numField;

    @FindBy(id = "com.google.android.calculator:id/digit_%d")
    private ExtendedWebElement digit;

    @Override
    public int multiply(int a, int b) {

        ExtendedWebElement firstElement = digit.format(a);
        ExtendedWebElement secondElement = digit.format(b);
        firstElement.click();
        multiplyButton.click();
        secondElement.click();
        equalsButton.click();
        pause(3);
        return Integer.parseInt(numField.getText());
    }
}
