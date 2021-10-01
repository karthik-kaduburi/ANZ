@ANZ-Feature
Feature: Acceptance testing to validate the ANZ Home page with form fields entry and
the response of the page based on appropriate input
  

  @Borrow-estimate-check
  Scenario Outline: Enter required form fields and verify the estimate
    Given I am on the Home Page "<url>" of "ANZ" Website
    When I enter the "yourDetailsInfo" on "<page>"
      | appType				|Single				|
      | noOfDep				|0						|
      | propToBuy			|Home					|
   Then I enter the "earningsInfo" on "<page>"
      | income				|80000				|
      | otherIncome		|10000				|
   And I enter the "expensesInfo" on "<page>"
      | liveExp				|500					|
      | homeLoanPay		|0						|
      | otherLoanPay	|100					|
      | otherCommit		|0						|
      | credLimit			|10000				|   
    When clicked on "workOut" link
    Then verify the "info" displayed on "<page>"
    	| estimate			|479,000			|
    Examples:
    |url																																			|page								|
    |https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|BorrowPage					|
  
  @Start-over-check
  Scenario Outline: Validate the functionality of start over button
    Given I am on the Home Page "<url>" of "ANZ" Website
    When I enter the "yourDetailsInfo" on "<page>"
      | appType				|Single				|
      | noOfDep				|0						|
      | propToBuy			|Home					|
   Then I enter the "earningsInfo" on "<page>"
      | income				|80000				|
      | otherIncome		|10000				|
   And I enter the "expensesInfo" on "<page>"
      | liveExp				|500					|
      | homeLoanPay		|0						|
      | otherLoanPay	|100					|
      | otherCommit		|0						|
      | credLimit			|10000				|   
    When clicked on "workOut" link
    Then clicked on "startOver" link
    Then verify the "clearance of form fields" displayed on "<page>"
    	| income				|0						|
      | otherIncome		|0						|
      | liveExp				|0						|
      | homeLoanPay		|0						|
      | otherLoanPay	|0						|
      | otherCommit		|0						|
      | credLimit			|0						|  
    Examples:
    |url																																			|page								|
    |https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|BorrowPage					|
    
    @estimate-message-check
  Scenario Outline: verify the message displayed on start over click
    Given I am on the Home Page "<url>" of "ANZ" Website
    When I enter the "yourDetailsInfo" on "<page>"
      | appType				|Single				|
      | noOfDep				|0						|
      | propToBuy			|Home					|
   Then I enter the "earningsInfo" on "<page>"
      | income				|0						|
      | otherIncome		|0						|
   And I enter the "expensesInfo" on "<page>"
      | liveExp				|1						|
      | homeLoanPay		|0						|
      | otherLoanPay	|0						|
      | otherCommit		|0						|
      | credLimit			|0						|   
    When clicked on "workOut" link
    Then verify the "info" displayed on "<page>"
    	| message				|<message>			|
    Examples:
    |url																																			|page								|message|
    |https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|BorrowPage					|Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641.|