@navigations
Feature: navigations

  Scenario: navigations test

    Given I navigate to "https://www.google.com"
    Then I navigate to "https://www.amazon.com"
    And I wait for 3 seconds
    Then I navigate back
    And I wait for 3 seconds
    Then I navigate forward
    And I wait for 3 seconds
    Then I refresh the page
    And I wait for 3 seconds
    Then I hold the browser open


#https://www.youtube.com/watch?v=b6XiTjQojys&t=58s installation
#https://github.com/abayramus/my-selenide-project
#https://www.youtube.com/watch?v=wS6ApQQcBsA

