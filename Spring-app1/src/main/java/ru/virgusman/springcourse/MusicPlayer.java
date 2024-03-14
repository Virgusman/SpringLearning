package ru.virgusman.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    public void doInit(){
        System.out.println("Init Player");
    }

    public void doDestroy(){
        System.out.println("Destroy Player");
    }
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    //IoC
/*
    public MusicPlayer(Music music) {
        this.music = music;
    }
*/

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MusicPlayer() {
    }

    public void playMusic() {
        musicList.forEach((x) -> System.out.println("Playing " + x.getSong()));
    }
}
