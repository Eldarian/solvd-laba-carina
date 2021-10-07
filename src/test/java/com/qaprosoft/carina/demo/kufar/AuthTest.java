package com.qaprosoft.carina.demo.kufar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.kufar.pages.KufarHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest implements IAbstractTest {
    @Test
    public void testCorrectAuth() {
        KufarHomePage homePage = new KufarHomePage(getDriver());
        homePage.open();
        homePage.closePopupMessage();
        homePage.login(R.TESTDATA.getDecrypted("login_email"), R.TESTDATA.getDecrypted("login_password"));
        Assert.assertTrue(homePage.isUserProfilePicPresent());
    }
}
