package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class RegionTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private KufarHomePage homePage;
    private RegionSelectionMenu regionSelectionMenu;

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Region Test Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.info("Region Test Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Region Test Before Class");
        getDriver().manage().window().fullscreen();
        homePage = new KufarHomePage(getDriver());
        homePage.open();
        pause(3);
        homePage.closePopupMessage();
    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("Region Test Before Method");
        regionSelectionMenu = homePage.openRegionSelectionMenu();
        regionSelectionMenu.selectRegion(0);
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P5)
    public void testAllBelarusSelection() {


        String region = regionSelectionMenu.selectRegion(0);
        regionSelectionMenu.confirm();
        pause(3);

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, region);
    }

    @Test
    public void testMinskCitySelection() {

        String region = regionSelectionMenu.selectRegion(1);
        regionSelectionMenu.confirm();
        pause(3);


        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Минск");
        Assert.assertEquals(selectedRegion, region);

    }

    @Test
    public void testLeninskiDistrictSelection() {

        String region = regionSelectionMenu.selectRegion(1);
        String district = regionSelectionMenu.selectTown(6);
        regionSelectionMenu.confirm();
        pause(3);

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Минск, Ленинский");
        Assert.assertTrue(district.equals(selectedRegion) || (region + ", " + district).equals(selectedRegion));
    }

    @Test
    public void testVetkaTownSelection() {

        String region = regionSelectionMenu.selectRegion(3);
        String town = regionSelectionMenu.selectTown(4);
        regionSelectionMenu.confirm();
        pause(3);

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Ветка");
        Assert.assertTrue(town.equals(selectedRegion) || (region + ", " + town).equals(selectedRegion));

    }

    @Test
    public void testBrestRegionSelection() {

        String region = regionSelectionMenu.selectRegion(2);
        regionSelectionMenu.confirm();
        pause(3);

        String selectedRegion = homePage.getSelectedRegionLabel();
        Assert.assertEquals(selectedRegion, "Брестская");
        Assert.assertEquals(selectedRegion, region);
    }

    @Test
    public void testExclusion() {
        LOGGER.info("this test should be excluded");
    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("Region Test After Suite");
    }

    @AfterTest
    public void afterTest() {
        LOGGER.info("Region Test After Test");
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("Region Test After Class");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("Region Test After Method");
        if(regionSelectionMenu.isConfirmClickable())
            regionSelectionMenu.confirm();
    }
}
