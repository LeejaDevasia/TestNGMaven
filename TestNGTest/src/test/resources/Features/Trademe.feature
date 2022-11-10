@Regression
Feature: Number of Cars from TradeMe
  
@NumberOfCarsFromMakes
  Scenario: Find Number of Cars from Makes
    Given Open broweser with url
    When when go to motors and click on makes
    Then Total Number of brand names should appear
    
    @NumberOfCarsFromMakes
  Scenario: Find Number of Cars from selected Brand Names
    Given Open broweser with url
    When when go to motors and click on makes
    And Click on "<makes>" 
    Then Total Number of cars with "<makes>" should appear
    
    Examples:
    |makes|
    |BMW|
    |Ferrari|
    |Mazda|
    |Honda| 
   

