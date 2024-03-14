package ru.virgusman.springcourse;

import org.springframework.beans.factory.annotation.Value;
import ru.virgusman.springcourse.genres.ClassicalMusic;
import ru.virgusman.springcourse.genres.FankMusic;
import ru.virgusman.springcourse.genres.RockMusic;

import java.util.List;


public class MusicPlayer {

    private final List<Music> music;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;


    public MusicPlayer(List<Music> music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic(GenreMusic genre) {
        switch (genre){
            case FANK -> {
                return music.stream().
                        filter((x)-> x.getClass().equals(FankMusic.class)).
                        findAny().
                        map(Music::getSong).orElse(null);
            }
            case CLASSICAL -> {
                return music.stream().
                        filter((x)-> x.getClass().equals(ClassicalMusic.class)).
                        findFirst().
                        map(Music::getSong).orElse(null);
            }
            case ROCK -> {
                return music.stream().
                        filter((x)-> x.getClass().equals(RockMusic.class)).
                        findFirst().
                        map(Music::getSong).orElse(null);
            }
        }
        return null;
    }
}
