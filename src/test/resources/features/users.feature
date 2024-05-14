Feature: CRUD Operations for Users

  Scenario: Retrieve user details by ID
    Given I have a user ID
    When I send a GET request to the /api/users/2 endpoint
    Then the response status code should be 200
    And the response should contain the user details

  Scenario: Create a new user
    Given I have a user payload
    When I send a POST request to the /api/users endpoint
    Then the response status code should be 201
    And the response should contain the created user details

  Scenario: Update user details
    Given I have a user payload for update
    When I send a PUT request to the /api/users/2 endpoint
    Then the response status code should be 200
    And the response should contain the updated user details

  Scenario: Partially update user details
    Given I have a user payload for partial update
    When I send a PATCH request to the /api/users/2 endpoint
    Then the response status code should be 200
    And the response should contain the updated user details

  Scenario: Delete user
    Given I have a user ID to delete
    When I send a DELETE request to the /api/users/2 endpoint
    Then the response status code should be 204
