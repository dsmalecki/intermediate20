package pl.sda.intermediate.playlist;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void sequenceModeTest() {
        Playlist playlist = new Playlist();
        Music music1 = new Music("Brown Sugar", "Rolling Stones");
        Music music2 = new Music("Innuendo", "Queen");
        Movie movie = new Movie("Casablanca");
        Playlist subPlaylist = new Playlist();
        Music music3 = new Music("Autobiografia", "Perfect");
        Music music4 = new Music("Final Countdown", "Europe");
        subPlaylist.addElementToList(music3, music4);
        playlist.addElementToList(music1);
        playlist.addElementToList(music2);
        playlist.addElementToList(movie);
        playlist.addElementToList(subPlaylist);
        System.out.println(playlist.play());
    }
    @RepeatedTest(5)
    void randomModeTest() {
        Playlist playlist = new Playlist();
        Music music1 = new Music("Brown Sugar", "Rolling Stones");
        Music music2 = new Music("Innuendo", "Queen");
        Movie movie = new Movie("Casablanca");
        Playlist subPlaylist = new Playlist();
        Music music3 = new Music("Autobiografia", "Perfect");
        Music music4 = new Music("Final Countdown", "Europe");
        subPlaylist.addElementToList(music3, music4);
        playlist.addElementToList(music1);
        playlist.addElementToList(music2);
        playlist.addElementToList(movie);
        playlist.addElementToList(subPlaylist);
        playlist.changePlayMode(PlayMode.RANDOM);
        System.out.println(playlist.play());
        System.out.println("--------------------------------");
    }
}
