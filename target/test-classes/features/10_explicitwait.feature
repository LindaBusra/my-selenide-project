@explicit_wait
Feature: explicit wait

  Scenario: TC01_explicit wait
    Given I navigate to "https://the-internet.herokuapp.com/dynamic_loading/1"
    And I set Configuration.screenshot to false
    And I click on start button
#    And I wait for 10 seconds     //It solves the problem but it is hard wait
    Then verify the Hello World! text is displayed
    And I hold the browser open


