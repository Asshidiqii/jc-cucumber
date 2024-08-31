Feature: Recruitment Candidate Management

  # TCC.HRM.0004
  Scenario: Adding a new candidate with valid information
    Given I am logged into OrangeHRM as an HR manager
    And I navigate to the Recruitment page
    When I click on the Add button in the Candidates section
    And I fill in all required candidate information with valid data
    And I click the Save button
    Then I should see the new candidate listed in the Candidates section

  # TCC.HRM.0005
  Scenario: Adding a new candidate with invalid format email information
    Given I am logged into OrangeHRM as an HR manager
    And I navigate to the Recruitment page
    When I click on the Add button in the Candidates section
    And I enter invalid format email
    And I click the Save button
    Then I should see an error message format email

  # TCC.HRM.0006
  Scenario: View details candidate
    Given I navigate to the Recruitment page
    When I looping function view details candidate

  # TCC.HRM.0007
  Scenario: Search candidate with status rejected
    Given I navigate to the Recruitment page
    When I selected status rejected
    And I click the Search button
    Then I should see the new candidate listed with status rejected
