package com.onlinestore.music;

import java.util.LinkedList;
import java.util.Queue;

        /*
        Illustration, when 4 different songs were played by a user & Initial capacity is 3:
Let's assume that the user has played 3 songs - S1, S2 and S3.
The playlist would look like -> S1,S2,S3
When S4 song is played -> S2,S3,S4
When S2 song is played -> S3,S4,S2
When S1 song is played -> S4,S2,S1
         */

public class PlaylistStore {

    private int capacity;
    private Queue<String> songQueue;

    public PlaylistStore(int capacity) {
        this.capacity = capacity;
        this.songQueue = new LinkedList<>();
    }

    public void playSong(String user, String songName) {
        songQueue.add(songName);
        if (songQueue.size() > capacity)
            songQueue.remove();
    }

    public Queue<String> getRecentPlaylist(String user) {
        return songQueue;
    }

    public int getCapacity() {
        return capacity;
    }
}
