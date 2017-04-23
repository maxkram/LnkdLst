package ru.maxkramer;

import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("Нет треков в плейлисте");
            return;
        }else{
            System.out.println(" Сейчас играет " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Плейлист закончен");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Сейчас играет " + listIterator.next().toString());
                    }else{
                        System.out.println("Конец плейлиста");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(" Сейчас играет " + listIterator.previous().toString());
                    }else{
                        System.out.println("Это начало плейлиста");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Сейчас играет " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("Начало плейлиста");
                        }
                    }else{
                        if(listIterator.hasNext()) {
                            System.out.println("Сейчас играет " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Конец плейлиста");
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
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Сейчас играет " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Сейчас играет " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("Доступные действия:\nнажмите");
        System.out.println("0 - выход\n" +
            "1 - следующий трек\n" +
            "2 - предыдущий трек\n" +
            "3 - проиграть снова\n" +
            "4 - показать все треки\n" +
            "5 - показать доступные действия" +
            "6 - удалить текущий трек");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("==================================");
    }
}
