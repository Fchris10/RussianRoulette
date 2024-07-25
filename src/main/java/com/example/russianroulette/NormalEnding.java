package com.example.russianroulette;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

public class NormalEnding {

    public void initialize(){
        normalEndingMusic();
    }

    private void normalEndingMusic() {
        String nameSong1 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\NBending.mp3";
        Media soundShot = new Media(new File(nameSong1).toURI().toString());
        MediaPlayer mediaPlayerShot = new MediaPlayer(soundShot);
        mediaPlayerShot.setVolume(10);
        mediaPlayerShot.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerShot.play();
    }

}