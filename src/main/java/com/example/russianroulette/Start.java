package com.example.russianroulette;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Start {

    @FXML
    public Button idStart;

    String nameSongStart = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\startSong.mp3";
    Media soundStart = new Media(new File(nameSongStart).toURI().toString());
    MediaPlayer mediaPlayerStart = new MediaPlayer(soundStart);
    @FXML
    private void initialize(){
        mediaPlayerStart.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerStart.setVolume(1);
        mediaPlayerStart.play();
    }

    public void startTheGame() throws IOException{
            mediaPlayerStart.stop();
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("DialogueStart.fxml"));
            Parent root = fxmlLoader1.load();
            Stage stage1 = (Stage) idStart.getScene().getWindow();
            stage1.setScene(new Scene(root, 700, 600));
    }
}
