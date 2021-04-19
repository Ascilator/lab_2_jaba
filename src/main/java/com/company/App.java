package com.company;

import com.company.DAO.*;
import com.company.song.Live;
import com.company.song.Single;
import com.company.song.Song;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public App() throws JAXBException, IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        new LogFile();

        SongsList<Song> songsList = new SongsList<>();

        //Dao<Song> daoJson = JsonDao.create("playlist5.json", App.class);
        //songsList.setList(daoJson.read());
        //daoJson.write(songsList.getList());

        //Dao<Song> daoCsv = CsvDao.create("playlist5.csv", App.class);
        //songsList.setList(daoCsv.read());
        //daoCsv.write(songsList.getList());

        //Dao<Song> daoXml = XMLDao.create("playlist3.xml", Song.class, App.class);
        //songsList.setList(daoXml.read());
        //daoXml.write(songsList.getList());

        for (Song song : songsList.getList()){
            song.check();
        }

        System.out.println("Наше русское православное меню:");
        System.out.println("1. Вывести список песен");
        System.out.println("2. Вывести по убыванию позиции в чарте");
        System.out.println("3. Вывести среднюю длину композиции");
        System.out.println("4. Узнать длину плейлиста");
        System.out.println("5. Выбрать песни по исполнителю");
        System.out.println("6. Сказать спасибо автору");
        System.out.println("======================================");
        System.out.println("7. Выйти");
        Scanner scanner = new Scanner(System.in);
        int menuItem = -1;
        while(true) {
            menuItem = scanner.nextInt();
            if(menuItem == 1) {
                System.out.println("==============Плейлист=================");
                List<Song> songs = songsList.getList();
                for (int i =0; i < songs.size(); i++) {
                    System.out.println(songs.get(i).Log());
                }
                System.out.println("=======================================");
            } else
            if (menuItem == 2) {
                songsList.sortByChart();
            }
            if (menuItem == 3) {
                songsList.averageDur();
            }
            if (menuItem == 4) {
                songsList.allDur();
            }
            if(menuItem == 5) {
                songsList.soutSinger();
            }
            if(menuItem == 6) {
                SongsList.thanks();
            }
            if(menuItem == 7) {
                break;
            }
        }


    }
}
