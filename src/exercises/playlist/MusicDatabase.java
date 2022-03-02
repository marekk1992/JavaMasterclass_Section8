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

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void addAlbumToList(Album album) {
        albums.add(album);
    }

    public void addToPlaylist(String songTitle) {
        Song mySong = findSongInAlbum(songTitle);
        if (mySong != null) {
            playlist.add(mySong);
            System.out.println("Song <" + mySong.getTitle() + "> added to playlist.");
        } else {
            System.out.println("You don`t have song with title <" + songTitle + "> in your database.");
        }
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
        for (Album album : albums) {
            Song song = album.findSongInAlbum(songTitle);
            if (song != null) {
                return song;
            }
        }
        return null;
    }

    public Album findAlbumInList(String name) {
        for (Album myAlbum : albums) {
            if (myAlbum.getName().equals(name)) {
                return myAlbum;
            }
        }
        return null;
    }
}
