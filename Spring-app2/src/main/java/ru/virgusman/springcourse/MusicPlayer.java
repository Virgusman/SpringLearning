package ru.virgusman.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MusicPlayer {
    private final Music music1;
    private final Music music2;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;


    @Autowired
    public MusicPlayer(@Qualifier("fankMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    @PreDestroy
    public void doMyInit(){
        System.out.println("Del");
    }
    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic(genreMusic genre) {
        switch (genre){
            case FANK -> {
                return music1.getSong();
            }
            case CLASSICAL -> {
                return music2.getSong();
            }
        }
        return null;
    }
}
