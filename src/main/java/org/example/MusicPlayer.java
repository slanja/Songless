package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    public static void LoadSong(File[] files, int index, JLabel songLabel) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File file = new File("songs/", files[index].getName());
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        songLabel.setText(file.getName());
    }

    public static void Play(Clip clip, long time) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(time);
        clip.stop();
    }

}
