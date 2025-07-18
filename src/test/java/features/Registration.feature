@tag
Feature: Login at https://www.saucedemo.com/
  A user must be able to login at https://www.saucedemo.com/

  Background:
    Given A user is on the login page

  @tag1
  Scenario Outline: Login at https://www.saucedemo.com/ using table
    When A user enters <username>, <password> for login
    Then A user successfully logged in as <username>, <password>
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @tag2
  Scenario Outline: Login at https://www.saucedemo.com/ using table
    When A user enters <username>, <password> for login
    Then The user is not authorised as <username>, <password> because the password is incorrect
    Examples:
      | username      | password  |
      | standard_user | incorrect |



