Feature: Recently Played Songs Store

  Scenario: Store and fetch recently played songs
    Given a recently played songs store with capacity of 3
    And the user "UserA" has played songs "S1, S2, S3"
    When the following songs are played by the user below
        | UserA | S4 |
    Then the recently played songs for the user should be the following
        | UserA | S2, S3, S4 |