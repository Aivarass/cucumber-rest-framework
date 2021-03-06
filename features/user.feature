@UserTests

  Feature: As a user I want to verify api response for users endpoint

    Scenario Outline: Verify users endpoint is returning expected values
      Given I get all user data from /user endpoint
      When I get user data for id: <id>
      Then I assert the following values in the api response:
        | id        | <idExpected>    |
        | name      | <name>          |
        | username  | <username>      |
        | phone     | <phone>         |
        | email     | <email>         |
        | website   | <website>       |
        | address   | <address>       |

      Examples:
        |id         | idExpected        | name                      | username          | email                     | phone                 | website       | address                                                                                                               |
        | 1         | 1                 | Leanne Graham             | Bret              | Sincere@april.biz         | 1-770-736-8031 x56442 | hildegard.org | {street=Kulas Light, suite=Apt. 556, city=Gwenborough, zipcode=92998-3874, geo={lat=-37.3159, lng=81.1496}}           |
        | 2         | 2                 | Ervin Howell              | Antonette         | Shanna@melissa.tv         | 010-692-6593 x09125   | anastasia.net | {street=Victor Plains, suite=Suite 879, city=Wisokyburgh, zipcode=90566-7771, geo={lat=-43.9509, lng=-34.4618}}       |
        | 3         | 3                 | Clementine Bauch          | Samantha          | Nathan@yesenia.net        | 1-463-123-4447        | ramiro.info   | {street=Douglas Extension, suite=Suite 847, city=McKenziehaven, zipcode=59590-4157, geo={lat=-68.6102, lng=-47.0653}} |
        | 4         | 4                 | Patricia Lebsack          | Karianne          | Julianne.OConner@kory.org | 493-170-9623 x156     | kale.biz      | {street=Hoeger Mall, suite=Apt. 692, city=South Elvis, zipcode=53919-4257, geo={lat=29.4572, lng=-164.2990}}          |
        | 5         | 5                 | Chelsey Dietrich          | Kamren            | Lucio_Hettinger@annie.ca  | (254)954-1289         | demarco.info  | {street=Skiles Walks, suite=Suite 351, city=Roscoeview, zipcode=33263, geo={lat=-31.8129, lng=62.5342}}               |
        | 6         | 6                 | Mrs. Dennis Schulist      | Leopoldo_Corkery  | Karley_Dach@jasper.info   | 1-477-935-8478 x6430  | ola.org       | {street=Norberto Crossing, suite=Apt. 950, city=South Christy, zipcode=23505-1337, geo={lat=-71.4197, lng=71.7478}}   |
        | 7         | 7                 | Kurtis Weissnat           | Elwyn.Skiles      | Telly.Hoeger@billy.biz    | 210.067.6132          | elvis.io      | {street=Rex Trail, suite=Suite 280, city=Howemouth, zipcode=58804-1099, geo={lat=24.8918, lng=21.8984}}               |
        | 8         | 8                 | Nicholas Runolfsdottir V  | Maxime_Nienow     | Sherwood@rosamond.me      | 586.493.6943 x140     | jacynthe.com  | {street=Ellsworth Summit, suite=Suite 729, city=Aliyaview, zipcode=45169, geo={lat=-14.3990, lng=-120.7677}}          |
        | 9         | 9                 | Glenna Reichert           | Delphine          | Chaim_McDermott@dana.io   | (775)976-6794 x41206  | conrad.com    | {street=Dayna Park, suite=Suite 449, city=Bartholomebury, zipcode=76495-3109, geo={lat=24.6463, lng=-168.8889}}       |
        | 10        | 10                | Clementina DuBuque        | Moriah.Stanton    | Rey.Padberg@karina.biz    | 024-648-3804          | ambrose.net   | {street=Kattie Turnpike, suite=Suite 198, city=Lebsackbury, zipcode=31428-2261, geo={lat=-38.2386, lng=57.2232}}      |

