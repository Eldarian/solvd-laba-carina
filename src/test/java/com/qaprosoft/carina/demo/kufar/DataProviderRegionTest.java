package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class DataProviderRegionTest implements IAbstractTest {

    @Test
    @Parameters({"region", "town"})
    public void testRegion(@Optional("3") int region, @Optional("2") int town) {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        RegionSelectionMenu regionSelectionMenu = homePage.openRegionSelectionMenu();

        String regionName = regionSelectionMenu.selectRegion(Integer.valueOf(region));
        String townName = regionSelectionMenu.selectTown(Integer.valueOf(town));
        regionSelectionMenu.confirm();

        String selectedRegion = homePage.getSelectedRegionLabel();
        if(townName != null) {
            Assert.assertTrue(townName.equals(selectedRegion) || (regionName + ", " + townName).equals(selectedRegion));
        } else {
            Assert.assertEquals(selectedRegion, regionName);
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
                LOGGER.info("94: " + itemRegion);
                Assert.assertEquals(item.getRegionLabelText(), selectedRegion);
            }
        } else if(!selectedRegion.equals("Вся Беларусь")) {
            for (LotItem item : homePage.getLotItems()) {
                String itemRegion = item.getRegionLabelText();
                itemRegion = itemRegion.split(", ")[1];
                LOGGER.info("100: " + itemRegion);
                Assert.assertEquals(itemRegion, selectedRegion);
            }
        }
    }

}
