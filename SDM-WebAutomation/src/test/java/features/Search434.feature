Feature: Search434

#  @search1
#  Scenario: SRP title
#    Given   I have entered a search term in the search box
#      | Excel         | Location                                           | Sheet       |
#      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh   |
#    When    I hit enter
#    Then    I should see the search term in the title of SRP
#      | Excel         | Location                                           | Sheet       |
#      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh   |

  @search
  Scenario: Search results product grid
    Given   I have entered a search term in the search box
    When    I hit enter
    Then    I should see the resulting PLP from search term

  @search
  Scenario: Search Results - Pharmaprix Product Assortment
    Given   I have entered a search term in the search box(Pharmaprix Product Assortment)
    When    I hit enter
    Then    I should only see products that are part of the Pharmaprix Assortment

  @search
  Scenario: Search results variant display on PLP
    Given   An item has multiple variants
    When    The product is displayed on a PLP
    Then    All colour and size variants should be grouped into a single product tile and there should be a count that indicates the number of variants


  @search
  Scenario: Shop link on SRP
    Given   I've executed a search query
    When    I land on the SRP
    Then    I should see the Shop link on the search page followed by the result text for the search term And the Shop link should be clickable

  @search
  Scenario: Search results - Category Redirect
    Given   I search a specific category (e.g. "Body Wash") that has a redirect associated
    When    I hit enter
    Then    I should arrive at a category PLP, showing breadcrumbs for category tree

  @search
  Scenario: Search results product no-type
    Given   I search a term that does not correspond to a product type or brand
    When    I hit enter
    Then    Breadcrumb should reflect Shop; Search [search term] and show the results related to my search term

  @search
  Scenario: Search Specific UPC
    Given   I search a specific product UPC
    When    I hit enter
    Then    It should return a SRP which has just the product that was searched.

  @search
  Scenario: Search results product grid
    Given   I have entered a search term in the search box
    When    I hit enter
    Then    I should see my search term on the top left default sort -  relevance

  @search   #453
  Scenario: Sorting on SRP
    Given   I am on the home page
    When    I execute a search based on a search term "red lipstick" that takes me to an SRP
    Then    The results displayed on the SRP will have the below sort options, with the first being the default: Relevance Price: Low to High Price: High to Low Newest
#  Note: Sort by Top Rated is OOS for M1.

  @search   #454
  Scenario: Sorting on CLP
    Given   I am on the home page
    When    I execute a search for a mapped keyword that takes me to a CLP "lipstick"
    Then    The results displayed on the CLP will have the below sort options, with the first being the default: Recommended Price: Low to High Price: High to Low Newest
#  Note: Sort by Top Rated is OOS for M1.


#  @search455
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
#
#  @search466
#  Scenario: Search- Relevance score
#    Given   A search query is made
#    When    There is a tie on relevance score across variants
#    Then    Then display the relevant variant that is in stock instead of the OOS one

  @search22
  Scenario: SRP Demo
    Given   I have entered a search term in the search box for demo test
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |
    When    I hit enter demo
    Then    I should see the search term in the title of SRP demo
      | Excel         | Location                                           | Sheet                 |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Search434Shivam-Singh |