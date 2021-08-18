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
        kufarHomePage.openFirstLot();
        LotDescriptionPage descriptionPage = new LotDescriptionPage(getDriver());
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

        Assert.assertEquals(nextPageBlock.getCurrentPageIndex(), currentPage + 1);

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
        if (town != null) {
            Assert.assertTrue(town.equals(selectedRegion) || (region + ", " + town).equals(selectedRegion));
        } else {
            Assert.assertEquals(selectedRegion, region);
        }

        pause(1);

        if (selectedRegion.contains(", ")) {
            for (LotItem item : homePage.getLotItems()) {
                Assert.assertEquals(item.getRegionLabelText(), selectedRegion);
            }
        } else if (!selectedRegion.equals("Вся Беларусь")) {
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
    public void testGalleryViewSwitch() {
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
        for (LotItem item : items) {
            int currentPrice = item.getPrice();
            Assert.assertTrue(currentPrice <= price, currentPrice + " > " + price);
            price = currentPrice;
        }
    }
}
