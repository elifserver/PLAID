Feature: Menu bar tests

  Background:
    Given User is opened the app

  Scenario: Defaults on the page check
    Then app name should be "Plaid"
    And page theme should become "light theme"

  Scenario: Check the icon count on the menu bar
  Then User should see 4 icons on the bar

  Scenario Outline: Search icon functionality check
    Then Menu item "<menuItem>" should be working properly
    Examples:
      | menuItem    |
      | Search      |
      | Theme       |
      | Filter      |
      | MoreOptions |

  Scenario: Theme switch check
    When User selects menu item "Theme"
    Then page theme should become "dark theme"
    And User waits for a while
    When User selects menu item "Theme"
    Then page theme should become "light theme"

  Scenario: Filter section - default selected filters check
    When User selects menu item "Filter"
    Then User should see "Popular Designer News" as selected
    And User should see "Material Design" as selected

  Scenario Outline: More Options check - Navigation to Login to Designer News
    Given User selects menu item "MoreOptions"
    When User selects option "<optionLabel>"
    Then Application should navigate to proper page
    Examples:
      | optionLabel            |
      | Login to Designer News |
      | About                  |

  Scenario Outline: Filter resultset check
    Given User unselected all the selected filters
    And User selects "<filter>"
    Then User should see results on the welcome screen
    Examples:
      | filter                |
      | Popular Designer News |
      | Material Design       |
      | Product Hunt          |

  Scenario: Filter resultset check - No filters selected
    When User unselected all the selected filters
    Then User should see no filter selected warning


