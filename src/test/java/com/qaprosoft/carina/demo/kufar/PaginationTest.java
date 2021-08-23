package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.kufar.components.PaginationBlock;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaginationTest implements IAbstractTest {

    private KufarHomePage homePage;
    private PaginationBlock paginationBlock;

    @BeforeMethod
    public void beforeMethod() {
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



}
