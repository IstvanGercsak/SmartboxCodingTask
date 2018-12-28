Feature:As a customer I want to view a list of products So I can select some to purchase

  Scenario: When searching for a box by name on the main search field (top of the page), suggestions are displayed as the customer types
    Given I go to the French Smartbox site
    And I click on the search field
    And I am looking for the product called "aventure"
    Then Search results are displays on the list with the name of "Aventure Insolite - Coffret Cadeau"

  Scenario: After selecting a category, filter options are displayed
    Given I go to the French Smartbox site
    And I click on the "Gastronomie" Category
    Then Filter options are displayed

  Scenario: Every Box page must display a link to the reviews section
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the rating title
    Then The reviews section become visible

#Failed test: The site does not work as it has to be based on the given specification

  @Ignore
  Scenario: When searching for a box by name on a filter, suggestions are displayed as the customer types
    Given I go to the French Smartbox site
    And I click on the "Gastronomie" Category
    And I type "aventure" on the filter field
    Then Search results are displays on the list