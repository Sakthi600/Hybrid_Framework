Feature: Search Functionality

  @TC_SF_001
  Scenario: Verify searching with an existing Product Name
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    Then "iMac" should be displayed in the search results

  @TC_SF_002
  Scenario: Verify searching with a non existing Product Name
    Given User opens the Application
    When User enters "Fitbit" in the Search field
    And User clicks the Search button
    Then no matching product message should be displayed

  @TC_SF_003
  Scenario: Verify searching without providing Product Name
    Given User opens the Application
    When User leaves the Search field empty
    And User clicks the Search button
    Then no matching product message should be displayed

  @TC_SF_004
  Scenario: Verify searching after login
    Given User opens the Application
    When User logs into the Application
    And User enters "iMac" in the Search field
    And User clicks the Search button
    Then "iMac" should be displayed in the search results

  @TC_SF_005
  Scenario: Verify search criteria returning multiple products
    Given User opens the Application
    When User enters "Mac" in the Search field
    And User clicks the Search button
    Then more than one product should be displayed

  @TC_SF_006
  Scenario: Verify Search textbox placeholder
    Given User opens the Application
    Then Search field should be displayed

  @TC_SF_007
  Scenario: Verify Search using product description
    Given User opens the Application
    And User clicks the Search button
    When User enters "iLife" in the Search Criteria field
    And User enables search in product descriptions
    And User clicks the Search Criteria button
    Then "iMac" should be displayed in the search results

  @TC_SF_008
  Scenario: Verify Search by selecting category
    Given User opens the Application
    And User clicks the Search button
    When User enters "iMac" in the Search Criteria field
    And User selects category "Desktops"
    And User clicks the Search Criteria button
    Then "iMac" should be displayed in the search results

  @TC_SF_009
  Scenario: Verify Search by selecting subcategories
    Given User opens the Application
    And User clicks the Search button
    When User enters "iMac" in the Search Criteria field
    And User selects category "Desktops"
    And User enables search in subcategories
    And User clicks the Search Criteria button
    Then "iMac" should be displayed in the search results

  @TC_SF_010
  Scenario: Verify List and Grid views with one product
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    And User selects List view
    Then List view should be displayed
    When User selects Grid view
    Then Grid view should be displayed

  @TC_SF_011
  Scenario: Verify List and Grid views with multiple products
    Given User opens the Application
    When User enters "Mac" in the Search field
    And User clicks the Search button
    And User selects List view
    Then List view should be displayed
    When User selects Grid view
    Then Grid view should be displayed

  @TC_SF_012
  Scenario: Verify user can sort products
    Given User opens the Application
    When User enters "Mac" in the Search field
    And User clicks the Search button
    And User selects Sort By option "Name (A - Z)"
    Then more than one product should be displayed

  @TC_SF_013
  Scenario: Verify navigation to Product Compare
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    And User clicks Product Compare
    Then Product Compare page should be displayed

  @TC_SF_014
  Scenario: Verify number of products displayed
    Given User opens the Application
    When User enters "Mac" in the Search field
    And User clicks the Search button
    And User selects Show option "25"
    Then more than one product should be displayed

  @TC_SF_015
  Scenario: Verify Search textbox and Search icon
    Given User opens the Application
    Then Search field should be displayed
    And Search button should be displayed

  @TC_SF_016
  Scenario: Verify Search field on application page
    Given User opens the Application
    Then Search field should be displayed
    And Search button should be displayed

  @TC_SF_017
  Scenario: Verify navigation to Search page from Site Map
    Given User opens the Application
    When User navigates to Search page
    Then Search field should be displayed

  @TC_SF_018
  Scenario: Verify Breadcrumb of Search page
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    Then Search breadcrumb should be displayed

  @TC_SF_019
  Scenario: Verify Search using keyboard
    Given User opens the Application
    When User performs search using keyboard
    Then "iMac" should be displayed in the search results

  @TC_SF_020
  Scenario: Verify Search page Heading Title and URL
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    Then Search page heading should be displayed
    And Search page title should be displayed
    And Search page URL should be displayed

  @TC_SF_021
  Scenario: Verify Search UI
    Given User opens the Application
    Then Search UI should be displayed correctly

  @TC_SF_022
  Scenario: Verify Search functionality
    Given User opens the Application
    When User enters "iMac" in the Search field
    And User clicks the Search button
    Then "iMac" should be displayed in the search results
