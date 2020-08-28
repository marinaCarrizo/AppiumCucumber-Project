Feature: A user access to Native View

  Background:
    Given I login with valid credentials "admin""admin"

  Scenario: A user access Native View feature
    When I choose the Native View option
    Then I should see the containers
      | Container | Text                        |
      | one       | Hello World, I'm View one   |
      | two       | Hello World, I'm View two   |
      | three     | Hello World, I'm View three |
