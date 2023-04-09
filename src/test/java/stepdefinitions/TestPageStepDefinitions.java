package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestPage;

import java.time.Duration;
import java.util.Locale;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.switchTo;

public class TestPageStepDefinitions {

    TestPage testPage = new TestPage();

    @Given("I enter username")
    public void i_enter_username() {

        testPage.username.setValue("techproed");  //.pressEnter();

    }

    @Given("I enter password")
    public void i_enter_password() {
        testPage.password.setValue("SuperSecretPassword");  //.pressEnter();
    }

    @Given("I enter submit button")
    public void i_enter_submit_button() {

        testPage.submitButton.click();
    }

    @And("I click on logout link")
    public void iClickOnLogoutLink() {
        testPage.logOutLink.click();
    }

    //Checkbox_radio
    @Given("I click on {string} if not already selected")
    public void i_click_on_if_not_already_selected(String string) throws InterruptedException {


        if (string.equals("Checkbox 1") && !testPage.checkbox1.isSelected()){
            testPage.checkbox1.shouldNot(Condition.checked);
            testPage.checkbox1.click();
            testPage.checkbox1.shouldBe(Condition.checked);
            wait(5);

        } else if (string.equals("Checkbox 2") && !testPage.checkbox2.isSelected()) {
            testPage.checkbox2.shouldNot(Condition.checked);
            testPage.checkbox2.click();
            testPage.checkbox2.shouldBe(Condition.checked);
            wait(5);
        } else if (string.equals("Red") && !testPage.red.isSelected()) {
            testPage.red.shouldNot(Condition.checked);
            testPage.red.click();
            testPage.red.shouldBe(Condition.checked);
            wait(5);

        } else if (string.equals("Yellow") && !testPage.yellow.isSelected()) {
            testPage.yellow.shouldNot(Condition.checked);
            testPage.yellow.click();
            testPage.yellow.shouldBe(Condition.checked);
            wait(5);

        } else if (string.equals("Football") && !testPage.football.isSelected()) {
            testPage.football.shouldNot(Condition.checked);
            testPage.football.click();
            testPage.football.shouldBe(Condition.checked);
            wait(5);
        }

    }

    //Dropdown

    @Given("I select the year as {int}")
    public void i_select_the_year_as(Integer int1) {
    testPage.year.selectOptionByValue(String.valueOf(int1));   //selecting by value
    }

    @Given("select the months as {string}")
    public void select_the_months_as(String string) {
    testPage.month.selectOption(string);    //selecting by visible text
    }

    @Given("I select the day as {int}")
    public void i_select_the_day_as(Integer int1) {
        testPage.day.selectOption(int1-1);   //index start from 0.  Select by index
    }

    @Given("I get the list of US states and click on {string}")
    public void i_get_the_list_of_us_states_and_click_on(String string) {

       for(SelenideElement myState : testPage.allStates) {
           System.out.println(myState.getText());  //printing the options
           if(myState.getText().equals(string)) {    //string ="Texas"

               myState.click();
               break;
           }
       }
    }


    //ALERTS
    @Given("I click on alert prompt")
    public void i_click_on_alert_prompt() {
        testPage.jsPromptButton.click();
    }


    @Given("I enter {string} and click OK")
    public void i_enter_and_click_ok(String string) {
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys(string);   //entering text
        WebDriverRunner.driver().switchTo().alert().accept();           //OK
    }


    @Then("I verify the result contains {string}")
    public void i_verify_the_result_contains(String string) {
        testPage.result.shouldHave(Condition.text(string));
    }


    //iframe

    @Given("I verify the page header contains {string}")
    public void i_verify_the_page_header_contains(String string) {
        //is outside of iframe
        testPage.pageHeader.shouldHave(Condition.text(string));
    }


    @Given("I switch to do frame {int}")
    public void i_switch_to_do_frame(Integer int1) {
       WebDriverRunner.getWebDriver().switchTo().frame(int1-1);   //1-1= 0 , the first frame which is index of 0
    }


    @Given("I click on Back to TechProEducation.com")
    public void i_click_on_back_to_tech_pro_education_com() {
        //inside the iframe
        testPage.backToTechpro.click();
    }

    //Switching Window
    @When("I switch to window {int}")
    public void i_switch_to_window(Integer int1) {

        switchTo().window(int1-1);
    }


    @Then("I get the URL of the page and verify it contains {string}")
    public void i_get_the_url_of_the_page_and_verify_it_contains(String string) {
        System.out.println(WebDriverRunner.url());      //we can use just url(), but we have to import...
        Assert.assertTrue(WebDriverRunner.url().contains(string));
    }


    @When("I drag the source in the target")
    public void i_drag_the_source_in_the_target() {

        //option 1
//        actions()
//                .dragAndDrop(testPage.source, testPage.target)  //moving source to target
//                .build()
//                .perform();    //reguired to execute the commands

        //option 2
//        actions().clickAndHold(testPage.source)
//                .moveToElement(testPage.target)
//                .build()
//                .perform();


        //option 3 : We can move the source to the spesific coordinates
        actions().dragAndDropBy(testPage.source, 305,167).build().perform();  //I can find the coordinate with inspect, after ctrl +F  -->position: relative; left: 305px; top: 167px;
    }


    @Given("I scroll the page down")
    public void i_scroll_the_page_down() {
        actions()
                .sendKeys(Keys.PAGE_DOWN)
                .build()
                .perform();

//        OR TO MOVE A LITTLE BIT
        actions()
                .sendKeys(Keys.ARROW_DOWN)
                .build()
                .perform();
    }


    //EXPLICIT WAIT
    @Given("I click on start button")
    public void i_click_on_start_button() {
        testPage.startButton.click();
    }


    @Then("verify the Hello World! text is displayed")
    public void verify_the_hello_world_text_is_displayed() {
        //Fails with no wait
//        System.out.println("Text is: " + testPage.helloWorld.getText());
//        Assert.assertEquals("Hello World!", testPage.helloWorld.getText());   //Fail

        //To fix the issue the best option is explicit wait because it is dynamic
        //1. way: Handle with WebDriverWait, it is coming from Selenium
//        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(testPage.helloWorld));
//        Assert.assertEquals("Hello World!", testPage.helloWorld.getText());     //Pass

        //2. way: Use Selenide wait
        testPage.helloWorld.should(Condition.visible, Duration.ofSeconds(20));
        Assert.assertEquals("Hello World!", testPage.helloWorld.getText());  //Pass

        testPage.helloWorld.should(Condition.text("fake test"));  //for show screenshot  -->under build-->reports-->tests


    }



}