package ru.virgusman.springcourse.genres;

import ru.virgusman.springcourse.Music;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


public class RockMusic implements Music {
    private final Set<String> songs = new HashSet<>();

    {
        songs.add("RockSong1");
        songs.add("RockSong2");
        songs.add("RockSong3");
    }
    @Override
    public String getSong() {
        return songs.stream().
                skip(ThreadLocalRandom.current().nextInt(songs.size())).
                findFirst().
                orElse(null);
    }
}
