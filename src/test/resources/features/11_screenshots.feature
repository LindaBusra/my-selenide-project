
Feature: screenshots

  @screenshot_page
  Scenario: TC01_screenshots
    Given I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page

  @screenshot_element
  Scenario: element_screenshots
    Given I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the programs pop up