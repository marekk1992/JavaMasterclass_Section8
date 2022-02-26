package exercises.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class MusicDatabase {

    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;

    public MusicDatabase() {
        albums = new ArrayList<Album>();
        playlist = new LinkedList<Song>();
    }

    public void addAlbumToList(Album album) {
        albums.add(album);
    }

    public boolean addToPlaylist(String songTitle) {
        Song mySong = findSongInAlbum(songTitle);
        if (mySong != null) {
            playlist.add(mySong);
            return true;
        }
        return false;
    }

    public void listSongsInPlaylist() {
        if (playlist.size() == 0) {
            System.out.println("Your playlist is empty.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + " --> " + playlist.get(i).getTitle()
                        + " (" + playlist.get(i).getDuration() + ")");
            }
        }
    }

    private Song findSongInAlbum(String songTitle) {
        int numberOfAlbums = albums.size();
        if (numberOfAlbums == 0) {
            return null;
        }
        for (int i = 0; i < numberOfAlbums; i++) {
            Song song = albums.get(i).findSongInAlbum(songTitle);
            if (song != null) {
                return song;
            }
        }
        return null;
    }

    public Album findAlbumInList(String name) {
        for (int i = 0; i < albums.size(); i++) {
            Album myAlbum = albums.get(i);
            if (myAlbum.getName().equals(name)) {
                return myAlbum;
            }
        }
        return null;
    }
}
