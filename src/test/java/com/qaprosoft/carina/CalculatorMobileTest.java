package com.qaprosoft.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.calculator.pages.common.CalcMainPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMobileTest implements IAbstractTest {

    @Test
    public void testMultuplyTwo() {
        CalcMainPageBase calc = initPage(getDriver(), CalcMainPageBase.class);
        pause(3);
        Assert.assertEquals(calc.multiply(), 4);
    }
}
