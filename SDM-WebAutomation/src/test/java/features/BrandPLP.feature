Feature: Brand_PLP

  @BrandPLP
  Scenario: Brand Landing Page Visuals
    Given   I am viewing the Brand Landing Page
    When    The page Loads
    Then    I can see the Logo as well as a large display of brand (mostly luxury beauty brands)

  @BrandPLP
  Scenario: Brand Landing Page Links (Chanel)
    Given  I am viewing the Brand Landing Page (Chanel)
    When   Clicking on header links
    Then   Takes me to the appropriate section of that brand


  @BrandPLP
  Scenario: BPLP badging
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I cannot see product badging (Chanel) but I can for others (Dior)


  @BrandPLP
  Scenario: BPLP product line
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I can see the product brand indicated


  @BrandPLP
  Scenario: BPLP product name
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I can see the product name indicated


  @BrandPLP
  Scenario: BPLP price
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I can see the product price or price range indicated

  @BrandPLP
  Scenario: BPLP favourite
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I cannot see the favourite option for certain BCLP (Chanel) but i can for others (Dior)

  @BrandPLP
  Scenario: BPLP Header
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I can see the brand header

  @BrandPLP
  Scenario: BPLP Filter
    Given   I am on a Brand PLP
    When    The page Loads
    Then    Then I don't see a brands filter in the filters list

  @BrandPLP
  Scenario: PDP indicates size and reviews
    Given   I am viewing a Brand CLP
    When    The page Loads
    Then    I cannot see the rating or size option for certain BCLP (Chanel) but I can for others (Dior)
