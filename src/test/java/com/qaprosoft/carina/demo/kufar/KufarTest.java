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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class KufarTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P1)
    public void testLotOpening() {
        KufarHomePage kufarHomePage = new KufarHomePage(getDriver());
        kufarHomePage.open();
        kufarHomePage.closePopupMessage();

        List<LotItem> itemList = kufarHomePage.getLotItems();
        for(LotItem lot : itemList) {
            LOGGER.info(lot.getLotLabel());
        }
        String label = itemList.get(0).getLotLabel();
        LOGGER.info("Lot[1] label is " + label);

        kufarHomePage.openFirstLot();
        LotDescriptionPage descriptionPage = new LotDescriptionPage(getDriver());
        LOGGER.info("Log description label text is " + descriptionPage.getLotLabelText());

        Assert.assertEquals(descriptionPage.getLotLabelText(), label);

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testNextPageButton() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        PaginationBlock paginationBlock = homePage.getPaginationBlock();
        Assert.assertTrue(paginationBlock.isNextPageButtonActive());

        int currentPage = paginationBlock.getCurrentPageIndex();
        homePage = paginationBlock.openNextPage();
        PaginationBlock nextPageBlock = homePage.getPaginationBlock();

        Assert.assertEquals(nextPageBlock.getCurrentPageIndex(), currentPage+1);

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P5)
    public void testRegionSelection() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String region = regionSelectionMenu.selectRegion(0);
        String town = regionSelectionMenu.selectTown(4);
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        if(town != null) {
            Assert.assertTrue(town.equals(selectedRegion) || (region + ", " + town).equals(selectedRegion));
        } else {
            Assert.assertEquals(selectedRegion, region);
        }

        LOGGER.info("Selected " + selectedRegion);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(selectedRegion.contains(", ")) {
            for (LotItem item : homePage.getLotItems()) {
                String itemRegion = item.getRegionLabelText();
                Assert.assertEquals(item.getRegionLabelText(), selectedRegion);
            }
        } else if(!selectedRegion.equals("Вся Беларусь")) {
            for (LotItem item : homePage.getLotItems()) {
                String itemRegion = item.getRegionLabelText();
                itemRegion = itemRegion.split(", ")[1];
                Assert.assertEquals(itemRegion, selectedRegion);
            }
        }
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testComputerCategoryOpenFromLeftMenu() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();

        homePage.openComputersCategory();
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
    }


    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testGalleryViewSwitch() {}


    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testFilterButtonAppearance() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();

        getDriver().manage().window().setSize(new Dimension(1100, 768));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(homePage.getFilterButton().isPresent());

        getDriver().manage().window().setSize(new Dimension(800, 768));
        Assert.assertTrue(homePage.getFilterButton().getElement().isDisplayed());
    }


    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P6)
    public void testResultSortByPrice() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();

        homePage.selectPriceSortByDescending();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int price = Integer.MAX_VALUE;
        List<LotItem> items = homePage.getLotItems();
        for (LotItem item : items) {
            int currentPrice = item.getPrice();
            Assert.assertTrue(currentPrice <= price, currentPrice + " > " + price);
            price = currentPrice;
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
