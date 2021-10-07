package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import com.qaprosoft.carina.demo.gui.kufar.pages.LotDescriptionPage;
import org.openqa.selenium.Dimension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @BeforeSuite
    public void beforeKufarSuite() {
        LOGGER.info("Kufar Test Before Suite");
    }

    @BeforeTest
    public void beforeKufarTest() {
        LOGGER.info("Kufar Test Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Kufar Test Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("Kufar Test Before Method");
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P1)
    public void testLotOpening() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        pause(1);
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
    public void testSearchClear() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        pause(3);
        homePage.closeSubscribePopup();


        homePage.typeToSearchbar("Hello world");
        pause(1);
        Assert.assertFalse(homePage.isSearchBarEmpty());
        homePage.clearSearchbarViaJS();
        Assert.assertTrue(homePage.isSearchBarEmpty());
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
        Assert.assertFalse(homePage.isFilterButtonPresent());

        getDriver().manage().window().setSize(new Dimension(800, 768));
        Assert.assertTrue(homePage.isFilterButtonPresent());
    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("Kufar Test After Suite");
    }

    @AfterTest
    public void afterTest() {
        LOGGER.info("Kufar Test After Test");
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("Kufar Test After Class");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("Kufar Test After Method");
    }

}
