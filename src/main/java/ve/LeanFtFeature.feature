Feature: Login and Shop
    Scenario: Check Dominik can log in
        Given I can navigate to www.advantageonlineshopping.com
        When  I select the profile button
        And   I login as dominikg with Password1
        Then  the username dominikg is displayed at profile icon