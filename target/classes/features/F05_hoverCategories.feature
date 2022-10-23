@smoke
Feature: F05_HoverCategories | users could over Categories and select one of sub options successfully

  Scenario: user  hover on one of main categories then click on sub category
    Given user hover on one of the main categories
    When user can view sub category if exist
    Then user can select sub category or open main category