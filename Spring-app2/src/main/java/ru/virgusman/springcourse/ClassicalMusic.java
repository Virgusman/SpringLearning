package ru.virgusman.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ClassicalMusic implements Music {

    private final Set<String> songs = new HashSet<>
            (Arrays.asList("ClassicalSong1", "ClassicalSong2", "ClassicalSong3"));

    @Override
    public String getSong() {
        //int randomIndex = ThreadLocalRandom.current().nextInt(songs.size());
        return songs.stream().
                skip(ThreadLocalRandom.current().nextInt(songs.size())).
                findFirst().
                orElse(null);
    }
}
