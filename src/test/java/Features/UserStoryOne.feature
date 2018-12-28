Feature: As a Customer I want to find a desired box and add it to the cart So I can make adjustments prior to checkout

  Scenario: Product page shows Ajouter au panier option
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    Then Ajouter au panier button is clickable

  Scenario: When click on Ajouter au panier, Article(s) ajouté(s) au panier overlay appears
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the Ajouter au panier button
    Then Article ajouté au panier overlay appear

  Scenario: The options Continuer mes Achats and Vider le Panier are on the add to cart overlay
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the Ajouter au panier button
    Then "CONTINUER MES ACHATS" and "VOIR LE PANIER" is appears on the cart overlay

  Scenario: The product added to cart is on shopping cart page
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the Ajouter au panier button
    And I click on the Voir Le Panier button
    Then The choosen product is appers on the cart page

  Scenario: A selected box can be removed from the cart
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the Ajouter au panier button
    And I click on the Voir Le Panier button
    Then I click on the trash icon

#Failed test: The site does not work as it has to be based on the given specification

  @Ignore
  Scenario: No more than 5 boxes of each title can be purchased per time
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I am able to give six box on the cart
    And I click on the cart
    Then I can checkout with six items

  @Ignore
  Scenario: The Vider le Panier options is not appears on the add to cart overlay
    Given I go to the French Smartbox site
    And I choose from the "Gastronomie" Category the "Bistrots" sub-category
    And I pick the first item from the list
    And I click on the Ajouter au panier button
    Then "Vider le Panier" does not appears on the cart overlay