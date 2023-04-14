Feature: ABC

  @ABC
  Scenario: ABC1
    Given I have entered a search term in the search box for demo test1
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When I hit enter demo1
    Then I should see the search term in the title of SRP demo1
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |