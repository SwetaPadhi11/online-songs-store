Feature: Recently Played Songs Store

  Scenario: Store and fetch recently played songs
    Given a recently played songs store with a capacity of 3
    And the user "UserA" has played the songs "S1, S2, S3"
    When the song "S4" is played by "UserA"
    Then the recently played songs for "UserA" should be "S2, S3, S4"

    When the song "S2" is played by "UserA"
    Then the recently played songs for "UserA" should be "S3, S4, S2"

    When the song "S1" is played by "UserA"
    Then the recently played songs for "UserA" should be "S4, S2, S1"