package ru.virgusman.springcourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.virgusman.springcourse.*;
import ru.virgusman.springcourse.genres.ClassicalMusic;
import ru.virgusman.springcourse.genres.FankMusic;
import ru.virgusman.springcourse.genres.RockMusic;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.virgusman.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public FankMusic fankMusic() {
        return new FankMusic();
    }

    @Bean
    public List<Music> musicList() {
        // Этот лист неизменяемый (immutable)
        return Arrays.asList(classicalMusic(), rockMusic(), fankMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
