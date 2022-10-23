Feature: F06_Home Slider | users could slide between two slider (Nokia1020 and Iphone) successfully

  Scenario: user click on slider one Nokia1020
    Given first slider is clickable on home page
    Then user should navigate to clickable URL "Nokia1020"

  Scenario: user click on slider one Iphone
    Given  second slider is clickable on home page
    Then   user should navigate to clickable URL "Iphone"