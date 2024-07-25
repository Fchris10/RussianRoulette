package com.example.russianroulette;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class SecretRoom {
    @FXML private ImageView idImage2;
    @FXML private ImageView idFinalGun;
    @FXML private Button idContinue2;
    @FXML private Text idDialogue2;
    @FXML private Button idBackToGame;
    @FXML private Button idShot;
    @FXML private AnchorPane idAnchor;

    int countDialogue2 = 0, countFinalShot = 0;

    public void initialize() {
        idDialogue2.setText("you're not supposed to be here...");
        File imageRotate = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\limone.png");
        idImage2.setImage(new Image(imageRotate.toURI().toString()));
        idContinue2.setVisible(true);
    }

    public void onContinue2Clicked(ActionEvent actionEvent) {
        countDialogue2++;
        if (countDialogue2 == 1) {
            idDialogue2.setText("leave this room now\nor I'll kill you");
            idBackToGame.setVisible(true);
            idContinue2.setVisible(false);
            transitionShot();
        }
    }

    public void onBackClicked() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("RouletteGame.fxml"));
        Parent root = fxmlLoader1.load();
        RouletteController rouletteController = fxmlLoader1.getController();
        rouletteController.boolValueDeath(true);
        Stage stage1 = (Stage) idBackToGame.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }

    public void transitionShot() {
        PauseTransition pauseTransitionShot = new PauseTransition(Duration.seconds(5));
        pauseTransitionShot.play();
        pauseTransitionShot.setOnFinished(event -> {
            FadeTransition fadeTransitionShot = new FadeTransition(Duration.seconds(2), idShot);
            fadeTransitionShot.setFromValue(0);
            fadeTransitionShot.setToValue(1);
            fadeTransitionShot.play();
        });
    }

    public void onShotClicked(ActionEvent actionEvent) throws IOException {
        idShot.setVisible(false);
        countFinalShot++;
        if (countFinalShot == 1) {
            idFinalGun.setVisible(true);
            idContinue2.setVisible(false);
            idBackToGame.setVisible(false);
            switchFace2();
            idDialogue2.setText("DON'T DO IT!");
            scaleFace();
        }
    }

    public void switchFace() {
        File fileSwitchFace = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\limone.png");
        idImage2.setImage(new Image(fileSwitchFace.toURI().toString()));
    }

    public void switchFace2() {
        File fileSwitchFace = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\succo.png");
        idImage2.setImage(new Image(fileSwitchFace.toURI().toString()));
    }

    public void scaleFace() {
        ScaleTransition scaleTransitionFace = new ScaleTransition(Duration.seconds(5), idImage2);
        scaleTransitionFace.setFromY(0);
        scaleTransitionFace.setToY(2);
        scaleTransitionFace.setFromX(0);
        scaleTransitionFace.setToX(2);
        scaleTransitionFace.play();
        scaleTransitionFace.setOnFinished(event -> {
            idDialogue2.setVisible(true);
            idImage2.setVisible(true);
            switchFace();
            idDialogue2.setText("I win!");
            idFinalGun.setVisible(false);
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
            pauseTransition.play();
            pauseTransition.setOnFinished(event2 -> {
                InvisibleBE();
            });
        });
    }

    public void onFinalGunClicked() {
        InvisibleGE();
    }

    public void switchToBadEnding() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("BadEnding.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) idAnchor.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }

    public void InvisibleBE() {
        idFinalGun.setVisible(false);
        idImage2.setVisible(false);
        idDialogue2.setVisible(false);
        idBackToGame.setVisible(false);
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.play();
        pause.setOnFinished(event -> {
            playShot();
            PauseTransition pauseTransitionBE = new PauseTransition(Duration.seconds(2));
            pauseTransitionBE.play();
            pauseTransitionBE.setOnFinished(event1 -> {
                try {
                    switchToBadEnding();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

    }

    public void InvisibleGE() {
        idFinalGun.setVisible(false);
        idImage2.setVisible(false);
        idDialogue2.setVisible(false);
        idBackToGame.setVisible(false);
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.play();
        pause.setOnFinished(event -> {
            playShot();
            PauseTransition pauseTransitionGE = new PauseTransition(Duration.seconds(2));
            pauseTransitionGE.play();
            pauseTransitionGE.setOnFinished(event1 -> {
                try {
                    switchToGoodEnding();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

    }

    private void playShot() {
        String nameSong1 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\shot.mp3";
        Media soundShot = new Media(new File(nameSong1).toURI().toString());
        MediaPlayer mediaPlayerShot = new MediaPlayer(soundShot);
        mediaPlayerShot.setVolume(1);
        mediaPlayerShot.setCycleCount(1);
        mediaPlayerShot.play();
    }

    public void switchToGoodEnding() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("GoodEnding.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) idAnchor.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }
}