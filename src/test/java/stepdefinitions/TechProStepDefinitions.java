package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TestPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TechProStepDefinitions {

    TestPage testPage = new TestPage();

    @Given("I get the title of the current page and verity if it contains {string}")
    public void i_get_the_title_of_the_current_page_and_verity_if_it_contains(String string) {
//      getting the title of the page
        Assert.assertTrue(title().contains(string));
    }


    //Screenshot of programs elements
    @And("I capture the screenshot of the programs pop up")
    public void iCaptureTheScreenshotOfTheProgramsPopUp() {
        try {
            testPage.upcomingPrograms.screenshot();
        } catch (Exception e) {
        }


    }

}




