package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChallengesPage;
import pages.HomePage;
import java.io.IOException;
import java.util.List;

public class HomePageTest extends TestBase {
    HomePage homePage;

    public HomePageTest() throws IOException {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws IOException {
        initialization(browser);
        homePage= new HomePage();
    }

    @Test(description = " Verify the navBar elements have the correct href value")
    public void navBarTest() throws IOException {
    boolean isLogoVisible = homePage.isDisplay();
    Assert.assertTrue(isLogoVisible, "The logo isn't visible");
    List<Boolean> hrefValues = homePage.getHrfValue();
    Assert.assertEquals(true, hrefValues.contains(Boolean.valueOf(true)));
    }

    @Test(description = "verify all challenges appear")
    public void viewAllChallengesFunctionalityTest() throws IOException {
        int defaultExistentChallenges = homePage.getChallengesSize();
        ChallengesPage challengesPage = homePage.clickLink();
        int challengesAfterClickViewAlChallenges = challengesPage.getChallengesSize();
        Assert.assertNotEquals(defaultExistentChallenges, challengesAfterClickViewAlChallenges, "They are not equals");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
