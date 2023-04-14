Feature: Search434

  @search
  Scenario: SRP title
    Given   I have entered a search term in the search box
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    I should see the search term in the title of SRP
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search results product grid
    Given   I have entered a search term in the search box
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    I should see the resulting PLP from search term
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search Results - Pharmaprix Product Assortment
    Given   I have entered a search term in the search box(Pharmaprix Product Assortment)
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    I should only see products that are part of the Pharmaprix Assortment
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search results variant display on PLP
    Given   An item has multiple variants
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    The product is displayed on a PLP
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    Then    All colour and size variants should be grouped into a single product tile and there should be a count that indicates the number of variants
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |


  @search
  Scenario: Shop link on SRP
    Given   I've executed a search query
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I land on the SRP
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    Then    I should see the Shop link on the search page followed by the result text for the search term And the Shop link should be clickable
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search results - Category Redirect
    Given   I search a specific category (e.g. Body Wash) that has a redirect associated
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    I should arrive at a category PLP, showing breadcrumbs for category tree

  @search
  Scenario: Search results product no-type
    Given   I search a term that does not correspond to a product type or brand
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    Breadcrumb should reflect Shop; Search [search term] and show the results related to my search term
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search Specific UPC
    Given   I search a specific product UPC
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    It should return a SRP which has just the product that was searched.
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Search results product grid2
    Given   I have entered a search term in the search box
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter
    Then    I should see my search term on the top left default sort -  relevance
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |

  @search
  Scenario: Sorting on SRP
    Given   I am on the home page
    When    I execute a search based on a search term (red lipstick) that takes me to an SRP
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    Then    The results displayed on the SRP will have the below sort options, with the first being the default: Relevance Price: Low to High Price: High to Low Newest


  @search
  Scenario: Sorting on CLP
    Given   I am on the home page
    When    I execute a search for a mapped keyword that takes me to a CLP
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    Then    The results displayed on the CLP will have the below sort options, with the first being the default: Recommended Price: Low to High Price: High to Low Newest



#  @search455   # Duplicate
#  Scenario: Filters
#    Given   I am on any search or listing page "Facewash"
#    When    I view the filters
#    Then    I should see the facet count next to each filter to denote the number of products with that below facets:
#
##  Price
##  brandName
##  colourRange
##  skinType
##  hairType
##  formulationType
##  finish
##  concern
##  fragranceStyle
##  coverage
##  benefits
##  preferences
##  promotions*
##  shopByCollection
##  showInStock
##  shopByCollection
##  category
##
##  *Filtering by Ratings is also OOS.
# out of stock locator css="p[class='plp__statusText__3vD_0']"
  @search466
  Scenario: Search- Relevance score
    Given   A search query is made
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    There is a tie on relevance score across variants
    Then    Then display the relevant variant that is in stock instead of the OOS one
