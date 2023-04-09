
Feature: cross browser

  @headless
  Scenario: TC01 Running of headless

    #For cross browser testing, we should assign the browser type before opening the browser.
    #Otherwise selenide will open the browser on chrome
    Given I open the "headless" browser
    And I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page


  @firefox
  Scenario: TC02 Running of firefox

    Given I open the "firefox" browser
    And I navigate to "https://www.amazon.com"
    And I capture the screenshot of the page


  @edge
  Scenario: TC02 Running of edge

    Given I open the "edge" browser
    And I navigate to "https://www.amazon.com"
    And I capture the screenshot of the page


  @chrome
  Scenario: TC02 Running of edge

    Given I open the "chrome" browser
    And I navigate to "https://www.apple.com"
    And I capture the screenshot of the page

    #https://selenide.org/faq.html    read it for cross browser
    #https://www.mozilla.org/en-US/firefox/new/  for download firefox