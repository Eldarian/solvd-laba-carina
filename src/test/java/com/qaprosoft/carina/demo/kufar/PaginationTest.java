package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.PaginationBlock;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

public class PaginationTest implements IAbstractTest {

    private static final Logger LOGGER = Logger.getLogger(PaginationTest.class);

    private KufarHomePage homePage;
    private PaginationBlock paginationBlock;

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Pagination Test Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.info("Pagination Test Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Pagination Test Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("Pagination Test Before Method");
        homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testNextPageButtonOnFirstPage() {

        paginationBlock = homePage.getPaginationBlock();
        Assert.assertTrue(paginationBlock.isNextPageButtonActive());

        int currentPage = paginationBlock.getCurrentPageIndex();
        homePage = paginationBlock.openNextPage();
        PaginationBlock nextPageBlock = homePage.getPaginationBlock();
        pause(3);
        Assert.assertEquals(nextPageBlock.getCurrentPageIndex(), currentPage + 1);

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testNextPageButtonOnThirdPage(){
        paginationBlock = homePage.getPaginationBlock();
        Assert.assertTrue(paginationBlock.isNextPageButtonActive());

        int currentPage = paginationBlock.getCurrentPageIndex();
        homePage = paginationBlock.openNextPage();
        PaginationBlock nextPageBlock = homePage.getPaginationBlock();
        pause(3);
        Assert.assertEquals(nextPageBlock.getCurrentPageIndex(), currentPage + 1);

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testNextPageButtonOnLastPage() {

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testPreviousPageButtonOnFirstPage() {

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testPreviousPageButtonOnThirdPage() {

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testPreviousPageButtonOnLastPage() {

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testThirdPageButtonOnFirstPage() {

    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testThirdPageButtonOnThirdPage() {

    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("Pagination Test After Suite");
    }

    @AfterTest
    public void afterTest() {
        LOGGER.info("Pagination Test After Test");
    }

    @AfterClass
    public void afterClass() {
        LOGGER.info("Pagination Test After Class");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("Pagination Test After Method");
    }

}
