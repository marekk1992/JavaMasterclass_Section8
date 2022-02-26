package exercises.playlist;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private MusicDatabase database = new MusicDatabase();
    private LinkedList<Song> playlist = new LinkedList<Song>();

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
                    playSong();
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
        System.out.println("\t 5 - Play song.");

        System.out.println("\t 6 - Replay current song.");
        System.out.println("\t 7 - Skip forward to a next song.");
        System.out.println("\t 8 - Skip backward to a previous song.");
        System.out.println("\t 9 - Remove current song from playlist.");
        System.out.println("\t 10 - To quit the application.");
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
        System.out.print("Enter song name: ");
        String title = scanner.nextLine();
        System.out.print("Enter song duration: ");
        String duration = scanner.nextLine();
        Song newSong = new Song(title, duration);
        System.out.print("Enter album name where you want to add song <" + newSong.getTitle()
                + " (" + newSong.getDuration() + ")>: ");
        String albumName = scanner.nextLine();
        Album album = database.findAlbumInList(albumName);
        if (album != null) {
            if (album.findSongInAlbum(newSong.getTitle()) != null) {
                System.out.println("Song <" + newSong.getTitle() + "> already exists in <"
                        + album.getName() + "> album.");
            } else {
                album.addSong(newSong);
                System.out.println("Song <" + newSong.getTitle() + "(" + newSong.getDuration()
                        + ")> added to <" + album.getName() + "> album.");
            }
        } else {
            System.out.println("Can`t find album <" + albumName + ">.");
        }
    }

    public void addToPlaylist() {
        System.out.print("Enter song name: ");
        String title = scanner.nextLine();
        if (database.addToPlaylist(title)) {
            System.out.println("Song <" + title + "> added to playlist.");
        } else {
            System.out.println("There don`t have song with title <" + title + "> in your database.");
        }
    }

    public void playSong() {
        ListIterator<Song> listIterator = playlist.listIterator();
        if (listIterator.hasNext()) {
            System.out.println("Now playing --> " + listIterator.next().getTitle() + " ("
                    + listIterator.next().getDuration() + ")");
            printMenu();
        } else {
            System.out.println("No songs in playlist");
        }
    }
}