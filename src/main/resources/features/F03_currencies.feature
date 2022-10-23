@smoke
Feature:F03_Currencies | user can change Currencies
  Scenario:guest user could change Currencies successfully
    Given Select Euro currency from the dropdown list on the top left of home page
    Then Find all Elements with Euro currency