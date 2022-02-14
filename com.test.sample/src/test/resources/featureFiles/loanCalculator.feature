Feature: Loan Calculator feature

  @Regression @Smoke
  Scenario Outline: Verify that user is able to calculate the home loan
    Given user access URL
    When I enter the information in details section with given details<applicationType>dependants<dependants>and<property>property
    When I enter the information in your earnings section<annualIncome>and<otherIncome>otherincome
    When I enter the information in your expenses section<monthly>repayments<repayments>otherloan<otherLoan>commitments<commitments>creditcard<creditCard>
    Then I should validate the correct estimation<estimation> is calculated or not
    Then I should click on startOver it should clear the form
    
    Examples: 
      | applicationType| dependants| property        | annualIncome | otherIncome | monthly|repayments|otherLoan|commitments|creditCard|estimation |
      | Single         |        0  | Home to live in |   80000      |       10000 |    500 |     0    |    100  |       0   |  10000   |    $482,000 |