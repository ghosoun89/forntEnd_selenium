package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChallengesPage extends TestBase {
    public ChallengesPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(css="#content > div > main > div > ul > li"))
    List<WebElement> allChallenges;
    @FindBy(className = "DropdownFilter__Button-c47e06-1")
    WebElement filterByButton;
    @FindBy(className = "Checkbox__Wrapper-sc-1gsbbbb-0")
    WebElement freeFilter;
    @FindBys(@FindBy(css="#content > div > main > div > ul > li > .ChallengeCard__Labels-luiznt-1> span"))
    List<WebElement> challengesLabel;
    @FindBy(css = ".ChallengeCard__Content-luiznt-3 > h3 > a")
    WebElement firstChallenge;
    @FindBy(className = "heading-wrapper")
    WebElement challengeNavBarWord;

    public int getChallengesSize(){
        return allChallenges.size();
    }

    public void selectDropdown(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(filterByButton));
        filterByButton.click();
        freeFilter.click();
    }

    public List<String> getLabelText(){
        List<String> labelsValue = new ArrayList<>();
        for(WebElement we: challengesLabel){
            labelsValue.add(we.getText());
        }
        return labelsValue;
    }

    public String getChallengeTitle(){
        return firstChallenge.getText();
    }

    public ChallengePage clickOnChallenge() throws IOException {
        firstChallenge.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(challengeNavBarWord));
        return new ChallengePage();
    }
}
