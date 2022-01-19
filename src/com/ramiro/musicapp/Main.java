package com.ramiro.musicapp;

import com.ramiro.musicapp.entities.Album;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {




        Album album = new Album("Turn on the Bright Lights","Interpol");
        album.addSong("Untitle",3.56);
        album.addSong("Obstacle 1",3.56);
        album.addSong("NYC",3.56);
        album.addSong("PDA",3.56);

        Album album2 = new Album("Our love to admire","Interpol");
        album2.addSong("Pionner to the falls",4.5);
        album2.addSong("The sacele",4.5);
        album2.addSong("Rest my chemestry",4.5);
        album2.addSong("The light house",4.5);

        albums.add(album);
        albums.add(album2);

        System.out.println(albums);

    }
}
