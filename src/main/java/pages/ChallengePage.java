package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChallengePage extends TestBase {
    public ChallengePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    WebElement challengeTitle;
    @FindBy(css = "details")
    WebElement FAQFirstQuestion;

    public String getChallengeTitle(){
        return challengeTitle.getText();
    }

    public void clickOnToggle(){
        FAQFirstQuestion.click();
    }

    public String isHasAttribute(){
        return FAQFirstQuestion.getAttribute("open");
    }
}
