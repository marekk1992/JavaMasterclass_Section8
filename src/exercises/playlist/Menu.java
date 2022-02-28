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
                case 11:
                    quit = true;
                    break;
            }
        }
    }

    public void printMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print playlist.");
        System.out.println("\t 2 - Create new album.");
        System.out.println("\t 3 - Add song to album.");
        System.out.println("\t 4 - Add song to playlist.");
        System.out.println("\t 5 - Open music player.");
        System.out.println("\t 6 - Close music player (*only with opened music player).");
        System.out.println("\t 7 - Replay current song (*only with opened music player).");
        System.out.println("\t 8 - Play next song (*only with opened music player).");
        System.out.println("\t 9 - Play previous song (*only with opened music player).");
        System.out.println("\t 10 - Remove current song from playlist (*only with opened music player).");
        System.out.println("\t 11 - To quit the application.");
    }

    public void createNewAlbum() {
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

    public void addSongToAlbum() {
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

    public void addToPlaylist() {
        System.out.print("Enter song name: ");
        String title = scanner.nextLine();
        database.addToPlaylist(title);
    }

    public void openMusicPlayer() {
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
        }

        while (!quit) {
            System.out.println("Enter your choice:  ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 6:
                    System.out.println("Closing music player...............");
                    quit = true;
                    break;
                case 7:
                    if (goingForward) {
                        System.out.println("Now playing " + listIterator.previous().getTitle() + ".");
                    } else {
                        System.out.println("Now playing " + listIterator.next().getTitle() + ".");
                    }
                    break;
                case 8:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of playlist.");
                        goingForward = false;
                    }
                    break;
                case 9:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            goingForward = false;
                        }
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 10:
                    int indexToRemove = listIterator.nextIndex();
                    Song song = database.getPlaylist().get(indexToRemove);
                    String name = song.getTitle();
                    System.out.println("Song " + name + " removed from the playlist.");
                    database.getPlaylist().remove(indexToRemove);
            }
        }
    }
}