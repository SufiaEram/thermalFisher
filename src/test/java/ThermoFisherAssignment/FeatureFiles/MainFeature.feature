Feature: To verify webtable on quick order page


Scenario: user want to access https://www.thermofisher.com/ 
  verify Webtable had 10 colum and 4 rows on quick order page 
    Given User Need to navigate to webpage
    When access quick order page 
    Then Verify 10 rows and 4 colums 
    And return the columns headers        