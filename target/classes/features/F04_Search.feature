@smoke
Feature: F04_Search | users could use search functionality to get product successfully

  Scenario Outline: user could search using product name
    Given user enter search "<Keyword>" and get search result
    When user get search result on valid page
    Then user find each result contains the search word by keyword "<Keyword>"
    Examples:
      | Keyword |
      | book    |
      | laptop  |
      | nike    |

  Scenario Outline: user could search using product name using sku
    Given user enter search "<sku>" and get search result
    When user click on the product in search result
    Then user find each result contains the search word by sku "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
      | AP_MBP_13 |
