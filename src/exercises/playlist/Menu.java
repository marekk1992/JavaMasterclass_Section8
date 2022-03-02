package exercises.playlist;

import java.util.ListIterator;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private MusicDatabase database = new MusicDatabase();

    public void operateMusicDatabase() {
        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    database.listSongsInPlaylist();
                    break;
                case 2:
                    createNewAlbum();
                    break;
                case 3:
                    addSongToAlbum();
                    break;
                case 4:
                    addToPlaylist();
                    break;
                case 5:
                    openMusicPlayer();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print playlist.");
        System.out.println("\t 2 - Create new album.");
        System.out.println("\t 3 - Add song to album.");
        System.out.println("\t 4 - Add song to playlist.");
        System.out.println("\t 5 - Open music player.");
        System.out.println("\t 6 - To quit the application.");
    }

    private void printPlayerMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Close music player.");
        System.out.println("\t 1 - Replay current song.");
        System.out.println("\t 2 - Play next song.");
        System.out.println("\t 3 - Play previous song.");
        System.out.println("\t 4 - Remove current song from playlist.");
    }

    private void createNewAlbum() {
        System.out.print("Enter album name: ");
        String title = scanner.nextLine();
        if (database.findAlbumInList(title) == null) {
            Album newAlbum = new Album(title);
            database.addAlbumToList(newAlbum);
            System.out.println("New album <" + newAlbum.getName() + "> created.");
        } else {
            System.out.println("Album <" + title + "> already exists.");
        }
    }

    private void addSongToAlbum() {
        Song newSong = createSong();
        System.out.print("Enter album name where you want to add song <" + newSong.getTitle()
                + " (" + newSong.getDuration() + ")>: ");
        String albumName = scanner.nextLine();
        Album album = database.findAlbumInList(albumName);
        if (album != null) {
            addNewSong(album, newSong);
        } else {
            System.out.println("Can`t find album <" + albumName + ">.");
        }
    }

    private void addNewSong(Album album, Song song) {
        if (album.findSongInAlbum(song.getTitle()) != null) {
            System.out.println("Song <" + song.getTitle() + "> already exists in <"
                    + album.getName() + "> album.");
        } else {
            album.addSong(song);
            System.out.println("Song <" + song.getTitle() + "(" + song.getDuration()
                    + ")> added to <" + album.getName() + "> album.");
        }
    }

    private Song createSong() {
        System.out.print("Enter song name: ");
        String title = scanner.nextLine();
        System.out.print("Enter song duration: ");
        String duration = scanner.nextLine();
        return new Song(title, duration);
    }

    private void addToPlaylist() {
        System.out.print("Enter song name: ");
        String title = scanner.nextLine();
        database.addToPlaylist(title);
    }

    private void openMusicPlayer() {
        boolean quit = false;
        boolean goingForward = true;
        System.out.println("Opening music player...............");
        ListIterator<Song> listIterator = database.getPlaylist().listIterator();
        if (database.getPlaylist().isEmpty()) {
            System.out.println("No songs in playlist");
            System.out.println("Closing music player...............");
            printMenu();
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printPlayerMenu();
        }

        while (!quit) {
            System.out.println("Enter your choice:  ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    closeMusicPlayer();
                    quit = true;
                    break;
                case 1:
                    goingForward = replaySong(listIterator, goingForward);
                    break;
                case 2:
                    goingForward = playNextSong(listIterator, goingForward);
                    break;
                case 3:
                    goingForward = playPreviousSong(listIterator, goingForward);
                    break;
                case 4:
                    removeCurrentSong(listIterator);
                    break;
            }
        }
    }

    private void closeMusicPlayer() {
        System.out.println("Closing music player...............");
        printMenu();
    }

    private boolean replaySong(ListIterator<Song> listIterator, boolean movingForwardInList) {
        if (movingForwardInList) {
            System.out.println("Now playing " + listIterator.previous().getTitle());
            movingForwardInList = false;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            movingForwardInList = true;
        }
        return movingForwardInList;
    }

    private boolean playNextSong(ListIterator<Song> listIterator, boolean movingForwardInList) {
        if (!movingForwardInList) {
            if (listIterator.hasNext()) {
                listIterator.next();
            }
            movingForwardInList = true;
        }
        if (listIterator.hasNext()) {
            System.out.println("Now playing " + listIterator.next().getTitle());
        } else {
            System.out.println("Reached the end of playlist.");
            movingForwardInList = false;
        }
        return movingForwardInList;
    }

    private boolean playPreviousSong(ListIterator<Song> listIterator, boolean movingForwardInList) {
        if (movingForwardInList) {
            if (listIterator.hasPrevious()) {
                listIterator.previous();
                movingForwardInList = false;
            }
        }
        if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous().getTitle());
        } else {
            System.out.println("We are at the start of the playlist");
            movingForwardInList = true;
        }
        return movingForwardInList;
    }

    private void removeCurrentSong(ListIterator<Song> listIterator) {
        int indexToRemove = listIterator.nextIndex();
        Song song = database.getPlaylist().get(indexToRemove);
        String name = song.getTitle();
        System.out.println("Song " + name + " removed from the playlist.");
        database.getPlaylist().remove(indexToRemove);
    }
}