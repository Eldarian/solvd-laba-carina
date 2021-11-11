package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.qaprosoft.carina.core.foundation.utils.common.CommonUtils.pause;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class SortTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testResultSortByPrice() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();

        homePage.selectPriceSortByDescending();
        pause(1);
        int price = Integer.MAX_VALUE;
        List<LotItem> items = homePage.getLotItems();
        SoftAssert asserter = new SoftAssert();
        for (int i = 3; i < items.size(); i++) {
            int currentPrice = items.get(i).getPrice();
            asserter.assertTrue(currentPrice <= price, currentPrice + " > " + price + " " + i);
            price = currentPrice;
        }
        asserter.assertAll();
    }
}
