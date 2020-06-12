@CommentPostTest

  Feature: As a user I want to verify api response for comment endpoint

    Scenario Outline: Verify comment endpoint is returning expected response when i post
      Given I provide values for comment request:
        | postId        | <postId>    |
        | id            | <id>        |
        | name          | <name>      |
        | email         | <email>     |
        | body          | <body>      |
      When I send the request to comments endpoint
      Then I verify that response status from comments endpoint is <status>
      And I verify that response body from comments endpoint is <response>

      Examples:
        | postId     | body       | id   | name     |  email          |  status   |  response  |
        | 1          | test1      | 1    | aivaras  |  test@test.com  | 201       | "id": 501 |
        | 2          | test2      | 2    | Luke     |  test@yahoo.com | 201       | "id": 501  |
        | 3          | test3      | 3    | Samantha |  test@gmail.com | 201       | "id": 501  |