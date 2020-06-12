@PostTests

  Feature: As a user I want to verify api response for posts endpoint

    Scenario Outline: Verify posts endpoint is returning expected response
      Given I provide values for request:
        | userId        | <userId>    |
        | body          | <body>      |
        | title         | <title>     |
      When I send the request to posts endpoint
      Then I verify that response status is <status>
      And I verify that response body is <response>

      Examples:
        | userId     | body       | title     |   status    |  response     |
        | 1          | test1      | title1    |   201       |  "id": 101  |
        | 2          | test2      | title2    |   201       |  "id": 101  |
        | 3          | test3      | title3    |   201       |  "id": 101  |