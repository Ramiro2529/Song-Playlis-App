package com.ramiro.musicapp.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album(){

    }

    public boolean addSong(String title, double duration){

        if(findSong(title)==null){
            songs.add(new Song(title,duration));
           // System.out.println(title+ ", Succesfully added to the album");
            return true;
        }else{
            //System.out.println("Song "+title+" already exist in the albums");
            return false;

        }

    }

    public Song findSong(String title){
        for (Song checkSong: songs){
            if(checkSong.getTitle().equals(title))
            return checkSong;
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index=trackNumber-1;
        if(index>0 && index <= this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
       // System.out.println("This album doesnt have song with tracknumber "+trackNumber);
            return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        for(Song checkSong: songs){
            if(checkSong.getTitle().equals(title)){
                playList.add(checkSong);
                return true;
            }
        }
      //  System.out.println("There is no such song in album");
        return false;
    }



}
