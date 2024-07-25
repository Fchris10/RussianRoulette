package com.example.russianroulette;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class BlackScene {
    @FXML private AnchorPane idBlack;

    String nameSong1 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\shot.mp3";
    Media soundShot = new Media(new File(nameSong1).toURI().toString());
    MediaPlayer mediaPlayerShot = new MediaPlayer(soundShot);

    public void initialize(){
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.5));
        pauseTransition.play();
        pauseTransition.setOnFinished(event -> {
            mediaPlayerShot.setVolume(10);
            mediaPlayerShot.setCycleCount(2);
            mediaPlayerShot.play();

            PauseTransition pauseTransition1 = new PauseTransition(Duration.seconds(2));
            pauseTransition1.play();
            pauseTransition1.setOnFinished(event1 -> {
                try {
                    onMouseMoved();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
    public void onMouseMoved() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("BadEnding.fxml"));
        Parent root = fxmlLoader2.load();
        Stage stage2 = (Stage) idBlack.getScene().getWindow();
        stage2.setScene(new Scene(root, 700, 600));
    }
}