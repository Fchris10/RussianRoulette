package com.example.russianroulette;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BadEnding {

    public void initialize(){
        badEndingMusic();
    }
    private void badEndingMusic() {
        String nameSong1 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\NBending.mp3";
        Media soundShot = new Media(new File(nameSong1).toURI().toString());
        MediaPlayer mediaPlayerShot = new MediaPlayer(soundShot);
        mediaPlayerShot.setVolume(10);
        mediaPlayerShot.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerShot.play();
    }
}