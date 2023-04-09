package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestPage;

import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;

public class CommonStepDefinitions {



    @And("I set Configuration.screenshot to false")
    public void iSetConfigurationScreenshotToFalse() {
        //will not take the screenshot even if the test case fails
        Configuration.screenshots = false;   //by default it is true
    }


    @Given("I capture the screenshot of the page")
    public void i_capture_the_screenshot_of_the_page() {
//        Selenide.screenshot("my_screenshot");//OR SIMPLY

        screenshot("image" );//giving a dynamic name   screenshot(new Date().toString());

    }


    @Given("I open the {string} browser")
    public void iOpenTheBrowser(String browserType) {

        switch (browserType) {

            case "headless" :
                Configuration.headless=true;        //by default it is false
                break;
            case "firefox" :
                Configuration.browser = "firefox";     //Configuration.browser = browserType  is same.
                break;
            case "safari" :
                Configuration.browser = "safari";
                break;
            case "edge" :
                Configuration.browser = "edge";
                break;
            default :
                Configuration.browser = "chrome";
                break;

        }
    }
}
