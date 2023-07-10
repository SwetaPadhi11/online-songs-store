Module Name: online-songs-store
Functions in the module:
  a. Get initial song list and capacity
  b. Play the next song
  c. Verify the Recently played songs playlist

Project description:
--------------------
Create a songs playlist for recently played songs that can accommodate N songs per user, with a fixed initial capacity. This playlist must have the capability to store a list of song-user pairs, with each song linked to a user. 
It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.

This project has been created in the command line using the below steps. This is a cucumber maven project.
It fetches the user, song and playlist data from the feature file and runs the test using the step definition class.



Test used in the project:

Illustration, when 4 different songs were played by a user & Initial capacity is 3: 
Let's assume that the user has played 3 songs - S1, S2 and S3.
The playlist would look like -> S1,S2,S3
When S4 song is played -> S2,S3,S4 
When S2 song is played -> S3,S4,S2 
When S1 song is played -> S4,S2,S1



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
