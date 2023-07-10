online-songs-store

Project description:
--------------------
Create a songs playlist for recently played songs that can accommodate N songs per user, with a fixed initial capacity. This playlist must have the capability to store a list of song-user pairs, with each song linked to a user. It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.

This project has been created in the command line using the below steps. This is a cucumber maven project.
It fetches the user, song and playlist data from the feature file and runs the test using the step definition class.


Steps to Create Project
-----------------------
mvn archetype:generate                      \
"-DarchetypeGroupId=io.cucumber"           \
"-DarchetypeArtifactId=cucumber-archetype" \
"-DarchetypeVersion=7.13.0"               \
"-DgroupId=online-songs-store"                  \
"-DartifactId=online-songs-store"               \
"-Dpackage=online.songs"                  \
"-Dversion=1.0.0-SNAPSHOT"                 \
"-DinteractiveMode=false"


Tools used:
-----------
Maven
BDD framework (Cucumber)
