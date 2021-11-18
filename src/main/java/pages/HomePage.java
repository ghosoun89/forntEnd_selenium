package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {
    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="#menu li a")
    WebElement first;
    @FindBy(css="#__next > header > div > a > picture > img")
    WebElement logo;
    @FindBys(@FindBy(css="#menu li a"))
    List<WebElement> list;
    @FindBys(@FindBy(css="#challenges > section > div > ul > li"))
    List<WebElement> challenges;
    @FindBy(css="[href=\"/challenges\"]")
    WebElement viewAllChallengesLink;

    public List<Boolean> getHrfValue(){
        String [] hrefValuesToVerify = {"/pro", "/challenges", "/solutions", "/resources", "/hiring"};
        List<Boolean> values = new ArrayList<Boolean>();
       for(int i = 0; i< list.size(); i++){
           values.add(list.get(i).getAttribute("href").contains(hrefValuesToVerify[i]));
        }
        return values;
    }

    public int getChallengesSize(){
        return challenges.size();
    }

    public ChallengesPage clickLink() throws IOException {
        viewAllChallengesLink.click();
        return new ChallengesPage();
    }

    public boolean isDisplay(){
        return logo.isDisplayed();
    }
}
