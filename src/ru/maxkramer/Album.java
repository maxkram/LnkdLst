
package ru.maxkramer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by maxkr on 4/23/2017.
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
        }
        return false;
    }

    private Song findSong(String title){
         for(Song checkedSong: this.songs){
             if(checkedSong.getTitle().equals(title)){
                 return checkedSong;
             }
         }
         return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if((index > 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.printf("В этом альбоме нет " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("В этом альбоме нет " + title);
        return false;
    }
}
