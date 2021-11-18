package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChallengePage;
import pages.ChallengesPage;
import pages.HomePage;
import java.io.IOException;
import java.util.List;

public class ChallengesPageTest extends TestBase {
    ChallengesPage challengesPage;
    HomePage homePage;
    ChallengePage challengePage;
    public ChallengesPageTest() throws IOException {
    }


    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws IOException {
        initialization(browser);
        homePage = new HomePage();
        challengesPage = new ChallengesPage();
    }

    @Test(description = "verify all the appearing challenges are free only")
    public void filterChallengesTest() throws IOException {
        challengesPage = homePage.clickLink();
        challengesPage.selectDropdown();
        List<String> labelsText = challengesPage.getLabelText();
        for(String str: labelsText){
         Assert.assertEquals(str, "FREE", "they are not equals");
         }
    }

    @Test(description = "verify you redirect to the selected challenge page")
    public void selectOneOfChallenge() throws IOException {
        String firstChallengeTitle = challengesPage.getChallengeTitle();
         challengePage = challengesPage.clickOnChallenge();
         String challengeTitle = challengePage.getChallengeTitle();
         Assert.assertEquals(firstChallengeTitle, challengeTitle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
