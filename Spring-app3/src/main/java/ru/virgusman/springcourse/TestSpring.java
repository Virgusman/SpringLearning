package ru.virgusman.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.virgusman.springcourse.config.SpringConfig;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        /*Music music = context.getBean("classicalMusic", Music.class);
        MusicPlayer player = new MusicPlayer(music);
        System.out.println(player.playMusic());*/

        //MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);
        context.close();
    }
}
