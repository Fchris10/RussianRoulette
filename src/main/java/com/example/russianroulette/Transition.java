package com.example.russianroulette;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Transition extends DialogueStart {

    @FXML
    public ImageView idDocSx;
    @FXML
    public ImageView idDocDx;
    @FXML
    public Button idNext;


    public void docSxTransition() {
        idDocSx.setVisible(true);
        TranslateTransition translateTransitionSx = new TranslateTransition(Duration.seconds(0.5), idDocSx);
        translateTransitionSx.setFromX(0);
        translateTransitionSx.setToX(100);

        translateTransitionSx.setOnFinished(event -> {
            TranslateTransition reverseTransition = new TranslateTransition(Duration.seconds(0.5), idDocSx);
            reverseTransition.setFromX(100);
            reverseTransition.setToX(0);

            reverseTransition.setOnFinished(e -> idDocSx.setVisible(false));
            reverseTransition.play();
        });
        translateTransitionSx.play();
    }
    public void docDxTransition() {
        idDocDx.setVisible(true);
        TranslateTransition translateTransitionDx = new TranslateTransition(Duration.seconds(0.5), idDocDx);
        translateTransitionDx.setFromX(0);
        translateTransitionDx.setToX(-80);

        translateTransitionDx.setOnFinished(event -> {
            TranslateTransition reverseTransition = new TranslateTransition(Duration.seconds(0.5), idDocDx);
            reverseTransition.setFromX(-80);
            reverseTransition.setToX(0);

            reverseTransition.setOnFinished(e -> idDocDx.setVisible(false));
            reverseTransition.play();
        });
        translateTransitionDx.play();
    }
    public void setRestart(){
        FadeTransition fadeTransitionRestart = new FadeTransition(Duration.seconds(1), idNext);
        fadeTransitionRestart.setFromValue(0);
        fadeTransitionRestart.setToValue(1);
        fadeTransitionRestart.play();
    }
}