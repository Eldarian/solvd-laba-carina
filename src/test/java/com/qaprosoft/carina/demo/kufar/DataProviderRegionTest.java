package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.demo.gui.kufar.components.LotItem;
import com.qaprosoft.carina.demo.gui.kufar.components.RegionSelectionMenu;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class DataProviderRegionTest implements IAbstractTest {

    /*@Test
    @Parameters({"region", "town"})*/
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path= "xls/demo.xlsx", executeColumn = "Execute", sheet = "Kufar", dsUid = "TUID", dsArgs = "region,town")
    public void testRegion(String region, String town) {
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
        pause(1);
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
