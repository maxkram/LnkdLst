package ru.maxkramer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by maxkr on 4/23/2017.
 */
public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.66);
        album.addSong("Holy man", 5.6);
        album.addSong("Hold on", 6.6);
        album.addSong("Lady double dealer", 2.6);
        album.addSong("You can't do it right", 1.6);
        album.addSong("High ball shooter", 4.76);
        album.addSong("The gypsy", 4.8);
        album.addSong("Soldier of fortune", 3.22);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Let's go", 3.22);
        album.addSong("Inject the venom", 4.11);
        album.addSong("Snowballed", 3.29);
        album.addSong("Evil walks", 2.58);
        album.addSong("C.O.D.", 2.35);
        album.addSong("Breaking the rules", 4.10);
        album.addSong("Night of long knives", 5.01);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(64, playList);

        play(playList);
    }
    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("Нет треков в плейлисте");
            return;
        }else{
            System.out.println("Сейчас играет " + listIterator.next().toString());
        }
    }
}
