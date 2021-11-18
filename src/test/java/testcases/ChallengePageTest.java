package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ChallengePage;
import pages.ChallengesPage;

import java.io.IOException;

public class ChallengePageTest extends TestBase {
    ChallengesPage challengesPage;
    ChallengePage challengePage;
    public ChallengePageTest() throws IOException {
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws IOException {
        initialization(browser);
        challengesPage = new ChallengesPage();
    }

    @Test(description = "verify the hidden text is appear")
    public void clickOnPlusIcon() throws IOException {
        challengePage = challengesPage.clickOnChallenge();
        String beforeClickToggle = challengePage.isHasAttribute();
        Assert.assertNull(beforeClickToggle, "It is exist");
        challengePage.clickOnToggle();
        String afterClickToggle = challengePage.isHasAttribute();
        Assert.assertEquals(afterClickToggle, "true","it isn't visible");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
