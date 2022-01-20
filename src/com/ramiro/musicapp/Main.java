package com.ramiro.musicapp;

import com.ramiro.musicapp.entities.Album;
import com.ramiro.musicapp.entities.Song;

import java.util.*;

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



       // System.out.println(albums);

        LinkedList<Song> playList1 = new LinkedList<>();

        albums.get(0).addToPlayList("Untitle",playList1);
        albums.get(1).addToPlayList("Rest my chemestry",playList1);

        play(playList1);

    }

    private static void play( LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator =playList.listIterator();
        if(playList.size()==0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing"+listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlis complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing"+listIterator.next().toString());
                    }else {
                        System.out.println("There is no song available, reached to the end of the list");
                        forward=false;
                    }
                    break;

                case 2:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("We are the first song");
                        forward=false;
                    }
                    break;
                case 3:

                    if(forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("We are at the start of teh list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward=true;
                        }else {
                            System.out.println("We are at the end of the list");
                        }
                    }

                    break;
                case 4:
                        printList(playList);

                    break;
                case 5:

                    printMenu();
                    break;

                case 6:

                    if(playList.size()==0){
                       listIterator.remove();
                       if(listIterator.hasNext()){
                           System.out.println("Now playing "+listIterator.next().toString());

                       }else {
                           if(listIterator.hasPrevious()){
                               System.out.println("Now playing "+listIterator.previous().toString());
                           }

                       }
                    }
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - play de next song\n"+
                "2 - play previuos song\n"+
                "3 - Replay de current song\n"+
                "4 - List of all songs\n"+
                "5 - Print all available options\n"+
                "6 - Delete current song");

    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator=playList.iterator();
        System.out.println("--------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");

    }
}
