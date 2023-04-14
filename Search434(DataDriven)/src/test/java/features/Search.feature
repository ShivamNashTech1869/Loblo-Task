Feature: Search


  @search55
  Scenario: Search results - Brand redirects
    Given Given I search a specific brand or badge (thoughtful choices)
      | Excel         | Location                                           | Sheet       |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1   |
    When When I hit enter
    Then It should take me to the specific brand PLP I searched
      | Excel         | Location                                           | Sheet     |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | SearchM1    |