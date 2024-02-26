package org.example;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static org.example.MusicPlayer.LoadSong;

public class Songless extends JFrame {
    private JPanel frame;
    private JButton button05s;
    private JButton button2s;
    private JButton button30s;
    private JLabel songLabel;
    private JButton button4s;
    private JButton button8s;
    private JButton nextButton;
    private JButton prevButton;
    private JButton button1s;
    private JButton button15s;

    private Clip clip;

    private int index = 0;

    File[] files;

    MusicPlayer musicPlayer = new MusicPlayer();

    private void initComponents() {
        setContentPane(frame);
        setTitle("Songless");
        setSize(700, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Songless() throws UnsupportedAudioFileException, IOException, LineUnavailableException { initComponents();
        File[] files =  new File("songs").listFiles();

        File file = new File("songs/", files[index].getName());
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        songLabel.setText(file.getName());

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object source = actionEvent.getSource();

                try {
                    if (source.equals(prevButton)) {
                        if (index == 0) index = files.length-1;
                        else index--;

                        File file = new File("songs/", files[index].getName());
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioStream);

                        songLabel.setText(file.getName());
                    }

                    if (source.equals(nextButton)) {
                        if (index == files.length-1) index = 0;
                        else index++;

                        File file = new File("songs/", files[index].getName());
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioStream);

                        songLabel.setText(file.getName());
                    }

                    if (source.equals(button05s)) MusicPlayer.Play(clip, 500);
                    if (source.equals(button1s)) MusicPlayer.Play(clip, 1000);
                    if (source.equals(button2s)) MusicPlayer.Play(clip, 2000);
                    if (source.equals(button4s)) MusicPlayer.Play(clip, 4000);
                    if (source.equals(button8s)) MusicPlayer.Play(clip, 8000);
                    if (source.equals(button15s)) MusicPlayer.Play(clip, 15000);
                    if (source.equals(button30s)) MusicPlayer.Play(clip, 30000);
                }
                catch(InterruptedException e){
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        prevButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        button05s.addActionListener(listener);
        button1s.addActionListener(listener);
        button2s.addActionListener(listener);
        button4s.addActionListener(listener);
        button8s.addActionListener(listener);
        button15s.addActionListener(listener);
        button30s.addActionListener(listener);
    }
}
