package com.example.russianroulette;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class GoodEnding {
    @FXML public Label idFinal;
    @FXML public Label idFinalSentence;
    @FXML private ImageView idP1, idP2;


    private MediaPlayer mediaPlayerClick;

    int countCodeFinal = 0;

    public void initialize() {
        musicGE();
        finalTransition();
    }

    public void finalTransition() {
        if (countCodeFinal == 0) {
            idFinal.setText("Thank you for playing");
            FadeTransition transitionIdFinal = new FadeTransition(Duration.seconds(3), idFinal);
            transitionIdFinal.setFromValue(0);
            transitionIdFinal.setToValue(1);
            transitionIdFinal.setOnFinished(event -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), idFinal);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(event2 -> {
                    countCodeFinal++;
                    finalTransition();
                });
                fadeOut.play();
            });
            transitionIdFinal.play();
        } else if (countCodeFinal == 1) {
            idFinal.setText("Programming:\nCsFr");
            FadeTransition transitionIdFinal = new FadeTransition(Duration.seconds(3), idFinal);
            transitionIdFinal.setFromValue(0);
            transitionIdFinal.setToValue(1);
            transitionIdFinal.setOnFinished(event -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), idFinal);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(event2 -> {
                    countCodeFinal++;
                    finalTransition();
                });
                fadeOut.play();
            });
            transitionIdFinal.play();
        } else if (countCodeFinal == 2) {
            idFinal.setText("Level Design:\nIsaFrisa");
            FadeTransition transitionIdFinal = new FadeTransition(Duration.seconds(3), idFinal);
            transitionIdFinal.setFromValue(0);
            transitionIdFinal.setToValue(1);
            transitionIdFinal.setOnFinished(event -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), idFinal);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(event2 -> {
                    countCodeFinal++;
                    finalTransition();
                });
                fadeOut.play();
            });
            transitionIdFinal.play();
        } else if (countCodeFinal == 3) {
            idFinal.setText("SoundTrack:\nCsFr");
            FadeTransition transitionIdFinal = new FadeTransition(Duration.seconds(3), idFinal);
            transitionIdFinal.setFromValue(0);
            transitionIdFinal.setToValue(1);
            transitionIdFinal.setOnFinished(event -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), idFinal);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(event2 -> {
                    backToBlack();
                });
                fadeOut.play();
            });
            transitionIdFinal.play();
        }
    }
    public void backToBlack() {
        FadeTransition fadeTransitionImage1 = new FadeTransition(Duration.seconds(3), idP1);
        FadeTransition fadeTransitionImage2 = new FadeTransition(Duration.seconds(3), idP2);
        fadeTransitionImage1.setFromValue(1);
        fadeTransitionImage1.setToValue(0);
        fadeTransitionImage2.setFromValue(1);
        fadeTransitionImage2.setToValue(0);
        fadeTransitionImage1.play();
        fadeTransitionImage2.play();
    }
    public void musicGE() {
        String nameSong2 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\song.m4a";
        Media soundClick = new Media(new File(nameSong2).toURI().toString());
        mediaPlayerClick = new MediaPlayer(soundClick);
        mediaPlayerClick.setCycleCount(1);
        mediaPlayerClick.setVolume(1);
        mediaPlayerClick.play();
    }
}