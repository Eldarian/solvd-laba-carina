package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.PaginationBlock;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import com.qaprosoft.carina.demo.gui.kufar.pages.LotDescriptionPage;
import org.openqa.selenium.Dimension;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KufarTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P1)
    public void testLotOpening() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePopupMessage();

        List<LotItem> itemList = kufarHomePage.getLotItems();
        String label = itemList.get(0).getLotLabel();

        LotDescriptionPage descriptionPage = kufarHomePage.openFirstLot();
        Assert.assertEquals(descriptionPage.getLotLabelText(), label);

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testComputerCategoryOpenFromLeftMenu() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        homePage.closeSubscribePopup();

        homePage.openComputersCategory();
        pause(1);
        Assert.assertTrue(homePage.getPageHeaderText().startsWith("Компьютерная техника"));
    }


    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testLanguageSwitch() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        homePage.closeSubscribePopup();

        homePage.switchLanguage();
        Assert.assertEquals(homePage.getPageHeaderText(), "Усе аб'явы ў Беларусі");
        homePage.switchLanguage();
        Assert.assertEquals(homePage.getPageHeaderText(), "Все объявления в Беларуси");
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testFilterButtonAppearance() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();

        getDriver().manage().window().setSize(new Dimension(1100, 768));
        pause(1);
        Assert.assertFalse(homePage.getFilterButton().isPresent());

        getDriver().manage().window().setSize(new Dimension(800, 768));
        Assert.assertTrue(homePage.getFilterButton().getElement().isDisplayed());
    }

}
