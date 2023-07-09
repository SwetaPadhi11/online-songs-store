package com.onlinestore.music;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyPlayedSongs {

    private static final Logger logger = LoggerFactory.getLogger(RecentlyPlayedSongs.class);
    private PlaylistStore store;
    private String currentUser;
    private Queue<String> currentSongs;

    @Given("a recently played songs store with a capacity of {int}")
    public void createRecentlyPlayedStore(int capacity) {
        store = new PlaylistStore(capacity);
        logger.info("Running tests...");
    }

    @Given("the user {string} has played the songs {string}")
    public void setRecentlyPlayedSongs(String user, String songs) {
        currentUser = user;
        currentSongs = new LinkedList<>(Arrays.asList(songs.split(", ")));
        for (String song : currentSongs) {
            store.playSong(user, song);
        }
    }

    @When("the song {string} is played by {string}")
    public void playSong(String song, String user) {
        store.playSong(user, song);
        currentSongs.add(song);
        if (currentSongs.size() > store.getCapacity()) {
            currentSongs.remove(0);
        }
    }

    @Then("the recently played songs for {string} should be {string}")
    public void verifyRecentlyPlayedSongs(String user, String expectedSongsStr) {
        Queue<String> expectedSongs = new LinkedList<>(Arrays.asList(expectedSongsStr.split(", ")));
        Queue<String> actualSongs = store.getRecentPlaylist(user);

        assertEquals(expectedSongs, actualSongs);
        logger.info("Assertion done for test..");
    }

}
