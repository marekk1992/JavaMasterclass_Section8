package exercises.playlist;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String title) {
        this.name = title;
        songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public Song findSongInAlbum(String songTitle) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(songTitle)) {
                return songs.get(i);
            }
        }
        return null;
    }
}
