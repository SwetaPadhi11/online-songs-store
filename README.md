online-songs-store


Steps to Create Project

mvn archetype:generate                      \
"-DarchetypeGroupId=io.cucumber"           \
"-DarchetypeArtifactId=cucumber-archetype" \
"-DarchetypeVersion=7.13.0"               \
"-DgroupId=online-songs-store"                  \
"-DartifactId=online-songs-store"               \
"-Dpackage=online.songs"                  \
"-Dversion=1.0.0-SNAPSHOT"                 \
"-DinteractiveMode=false"