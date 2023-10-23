Feature: Product Buy functionality

  @login @product
Scenario: user successfully product buy
   	Given user is on SauceDemo homepage
    When user click  product
	And user click shopping cart
	And user click checkout
	And user input firstname
	And user input lastname
	And user input postal code
	And user click continue
	And user click finish
	Then user verify success checkout result