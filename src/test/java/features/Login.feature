Feature: A user tries to login
  Scenario: A user logs in successfully
    When I enter my username "admin"
    And I enter my password "admin"
    And I attempt to login
    Then I should see the Samples List
      |Title           |
      |Native View     |
      |Slider          |
      |Vertical swiping|
      | Drag & Drop    |



  Scenario: A user logs in with invalid credentials
      When I enter my username "marina"
      And I enter my password "qwerty"
      And I attempt to login
      Then I should see the invalid credentials popup
