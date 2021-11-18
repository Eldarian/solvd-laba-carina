package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.PaginationBlock;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.pages.KufarHomePageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class PaginationTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private KufarHomePageBase homePage;
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
        homePage = initPage(getDriver(), KufarHomePageBase.class);
        homePage.open();
        //homePage.closePopupMessage();
        paginationBlock = homePage.getPaginationBlock();

    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("Pagination Test Before Method");
        pause(3);
        paginationBlock.openFirstPage();
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testNextPageButtonOnFirstPage() {

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
        Assert.assertTrue(paginationBlock.isNextPageButtonActive());
        paginationBlock.openLastPage();
        pause(3);
        Assert.assertFalse(paginationBlock.isNextPageButtonActive());
    }

    @Test
    @MethodOwner(owner = "eldarian")
    @TestPriority(Priority.P4)
    public void testPreviousPageButtonOnFirstPage() {
        Assert.assertFalse(paginationBlock.isPreviousPageButtonActive());
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
