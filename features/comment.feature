@CommentRetrieveTests

  Feature: As a user I want to verify api response for comments endpoint

    Scenario Outline: Verify comments endpoint is returning expected values for specific postId
      Given I get all comment data for postId: <postId>
      When I get a comment by comment id: <id>
      Then I assert the following values in the post response:
        | postId        | <expectedPostId>      |
        | id            | <expectedId>          |
        | name          | <name>                |
        | email         | <email>               |
        | body          | <body>                |

      Examples:
        | postId  | id  | expectedPostId  | expectedId  | name                                        | email                   | body |
        | 1       | 1   | 1               | 1           | id labore ex et quam laborum                | Eliseo@gardner.biz      | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |
        | 1       | 2   | 1               | 2           | quo vero reiciendis velit similique earum   | Jayne_Kuhic@sydney.com  | est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et |