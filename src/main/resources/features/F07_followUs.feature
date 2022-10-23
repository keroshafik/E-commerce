@smoke
Feature: F07_followUs | users could open followUs links

  Scenario: user opens facebook link
    Given user opens "linkedin" link
    When user displays new tab
    And user can switch between two tabs
    Then "https://www.facebook.com/nopCommerce" is opened in new tab


  Scenario: user opens twitter link
    Given user opens "google" link
    When user display new tab
    And user switch between two tabs
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
    Given user opens "wekepedia" link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user opens youtube link
    Given user opens "youtube" link
    When user display new tab
    And user switch between two tabs
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab
