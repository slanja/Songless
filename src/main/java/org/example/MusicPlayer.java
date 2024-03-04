package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private static Clip clip;

    public static void LoadAudio(String filePath) {
        File audioFile = new File(filePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void Play(long time) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();

        // waiting for specific time
        Thread.sleep(time);

        clip.stop();
    }

    public static void Play() throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();

        // wait until song ends
        while (clip.isRunning()) {
            Thread.sleep(10);
        }

        clip.stop();
    }
}