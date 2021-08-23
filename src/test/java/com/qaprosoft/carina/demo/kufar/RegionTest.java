package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static com.qaprosoft.carina.core.foundation.utils.common.CommonUtils.pause;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


public class RegionTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P5)
    public void testAllBelarusSelection() {
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
    public void testMinskCitySelection() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String region = regionSelectionMenu.selectRegion(1);
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Минск");
        Assert.assertEquals(selectedRegion, region);

    }

    @Test
    public void testLeninskiDistrictSelection() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String region = regionSelectionMenu.selectRegion(1);
        String district = regionSelectionMenu.selectTown(6);
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Минск, Ленинский");
        Assert.assertTrue(district.equals(selectedRegion) || (region + ", " + district).equals(selectedRegion));
    }

    @Test
    public void testVetkaTownSelection() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String region = regionSelectionMenu.selectRegion(3);
        String town = regionSelectionMenu.selectTown(4);
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Гомельская, Ветка");
        Assert.assertTrue(town.equals(selectedRegion) || (region + ", " + town).equals(selectedRegion));

    }

    @Test void testBrestRegionSelection() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String region = regionSelectionMenu.selectRegion(2);
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Брест");
        Assert.assertEquals(selectedRegion, region);
    }



}
