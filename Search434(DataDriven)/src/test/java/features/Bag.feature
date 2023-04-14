Feature: BAG
@Bag
  Scenario Outline: bag page - items display
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag
    Then my added products load on the page
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario: bag page - no items display
  Given I am on the bag page empty
  When I have not added products to my bag
  Then I am presented with the message that my bag is currently empty and option to keep shopping

  @Bag
  Scenario Outline: bag page - remove the only item
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I remove the item
    Then my bag should be empty
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: Bag page - add samples
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When  I have a qualifying product from the beauty category
    Then I can select up to 3 samples to be shipped alongside my order for free
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  @Bag
  Scenario Outline: Bag page - samples (Unqualified)
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I remove all qualifying product from the beauty category
    Then I no longer see samples in my bag
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  Scenario Outline: bag page - order summary calculations
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag and I have not signed in
    Then I am presented the summary calculations of my order but not the tax value
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |


  Scenario Outline: bag page - order summary calculations
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag and I have signed in with an account that has made it through checkout journey before
    Then I am presented the summary calculations of my order including the tax value
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  Scenario Outline: bag page - order summary calculationsunder50
    Given I am on the bag page under50 sheetname "<SheetName>" and rownumber <RowNumber>
    When  I have added products to my bag and my order is under fifty
    Then I am presented the summary calculations of my order and the shipping costs is shownas $eight
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

  Scenario Outline: bag page - order summary calculations
    Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
    When I have added products to my bag
    Then I am presented the summary calculations of my order and the shipping costs is shown as Free
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |

    Scenario Outline:bag page - quantity adjustment
     Given I am on the bag page sheetname "<SheetName>" and rownumber <RowNumber>
     When I select the plus and minus buttons
      Then  I am able to modify the quantity to a maximum ofsix quantities per product and then the plus button is greyed out
      Examples:
        | SheetName | RowNumber |
        | Search    | 0         |

      @Bag
  Scenario Outline: bag page - quantity adjustment
    Given I am on the bag page with a CHANEL product
    When I select the plus and minus buttons threetimes
    Then I am able to modify the quantity to a maximum ofthree quantities per product and then the plus button is greyed out
    Examples:
      | SheetName | RowNumber |
      | Search    | 0         |