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

    public static void Play05s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(500);
        clip.stop();
    }

    public static void Play1s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(1000);
        clip.stop();
    }

    public static void Play2s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(2000);
        clip.stop();
    }

    public static void Play4s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(4000);
        clip.stop();
    }

    public static void Play8s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(8000);
        clip.stop();
    }

    public static void Play15s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(15000);
        clip.stop();
    }

    public static void Play30s(Clip clip) throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
        Thread.sleep(30000);
        clip.stop();
    }
}
