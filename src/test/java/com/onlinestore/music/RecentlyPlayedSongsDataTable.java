package com.onlinestore.music;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyPlayedSongsDataTable {
    private static final Logger logger = LoggerFactory.getLogger(RecentlyPlayedSongs.class);
    private PlaylistStore store;
    private Queue<String> currentSongs;
    private String currentUser;


    @Given("a recently played songs store with capacity of {int}")
    public void createSongPlaylistStore(int capacity) {
        store = new PlaylistStore(capacity);
        logger.info("Running tests...");
    }
    @Given("the user {string} has played songs {string}")
    public void the_user_has_played_songs(String user, String songs) {
        currentUser = user;
        currentSongs = new LinkedList<>(Arrays.asList(songs.split(", ")));
        for (String song : currentSongs) {
            store.playSong(user, song);
        }
    }

    @When("the following songs are played by the user below")
    public void playSongByUser(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists(String.class);
        String user = data.get(0).get(0);
        String songPlayed = data.get(0).get(1);

        store.playSong(user, songPlayed);
        currentSongs.add(songPlayed);
        if (currentSongs.size() > store.getCapacity()) {
            currentSongs.remove(0);
        }


    }
    @Then("the recently played songs for the user should be the following")
    public void recentlyPlayedSong(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String user = data.get(0).get(0);
        String expectedSongsStr = data.get(0).get(1);

        Queue<String> expectedSongs = new LinkedList<>(Arrays.asList(expectedSongsStr.split(", ")));
        Queue<String> actualSongs = store.getRecentPlaylist(user);

        assertEquals(expectedSongs, actualSongs);
        logger.info("Assertion done for test..");
    }

}
