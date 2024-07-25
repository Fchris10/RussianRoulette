package com.example.russianroulette;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
public class DialogueStart {
    @FXML private ImageView idImage1;
    @FXML private Label idDialogue1;
    @FXML private TextField idNameP1;
    @FXML private TextField idNameP2;
    @FXML private Button idHey;
    @FXML private Button idPlay;
    @FXML private Button idAdd;
    @FXML private Button idContinue1;
    @FXML private Button idSkip;

    int countDialogue = 0;

    public void imageStart(){
        File fileImage = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\limone.png");
        idImage1.setImage(new Image(fileImage.toURI().toString()));
    }
    public void onHeyClicked() {
        idHey.setVisible(false);
        idSkip.setVisible(true);
        imageStart();
        idDialogue1.setText("Hello my friends, my name is D3al3r");
        idContinue1.setVisible(true);
    }
    public void onContinue1Clicked() {
        countDialogue++;
        if(countDialogue == 1){
            idDialogue1.setText("I'm here to introduce you \n a special game that only one \n will be able to survive");
        } else if(countDialogue == 2){
            idDialogue1.setText("It's called Russian Roulette,\nbut with a little twist");
        } else if(countDialogue == 3){
            idDialogue1.setText("You have 5 lives and there's a revolver \nwith a single bullet in the chamber.\nEach player will take turns pressing the trigger,\npointing the gun at their own head.");
        }else if(countDialogue == 4){
            idDialogue1.setText("After pressing the trigger, if the gun fires the bullet, you will roll the dice.\nIf you're lucky, a Doc will save your life");
        } else if(countDialogue == 5){
            idDialogue1.setText("The game continues until one of you loses all their lives.");
        } else if(countDialogue == 6){
            idDialogue1.setText("I don't want to waste any time. Lets play." + "\n" + "But first, type your names.");
            idNameP1.setVisible(true);
            idNameP2.setVisible(true);
            idContinue1.setVisible(false);
            idAdd.setVisible(true);
        } else if(countDialogue == 7){
            idDialogue1.setText("That the show has began" + "\n" + "Good luck... you need it");
            transitionPlayButton();
        }
    }
    public void onAddClicked() {
        idAdd.setVisible(false);
        idNameP1.setVisible(false);
        idNameP2.setVisible(false);
        onContinue1Clicked();
    }
    public void onPlayClicked() throws IOException{
            String nameP1 = idNameP1.getText();
            String nameP2 = idNameP2.getText();

            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("RouletteGame.fxml"));
            Parent root = fxmlLoader1.load();

            RouletteController rouletteController = fxmlLoader1.getController();
            rouletteController.setNamePlayers(nameP1, nameP2);

            Stage stage1 = (Stage) idPlay.getScene().getWindow();
            stage1.setScene(new Scene(root, 700, 600));
    }
    public void transitionPlayButton(){
        FadeTransition fadeImage = new FadeTransition(Duration.seconds(1), idImage1);
        fadeImage.setFromValue(1);
        fadeImage.setToValue(0);
        FadeTransition fadeText = new FadeTransition(Duration.seconds(2.5), idDialogue1);
        fadeText.setFromValue(1);
        fadeText.setToValue(0);

        fadeText.play();
        fadeText.setOnFinished(event1 -> {
            fadeImage.play();
            fadeImage.setOnFinished(event2 -> {
                FadeTransition fadeIdPlay = new FadeTransition(Duration.seconds(3), idPlay);
                fadeIdPlay.setFromValue(0);
                fadeIdPlay.setToValue(1);
                fadeIdPlay.play();
            });
        });
    }
    public void onSkipClicked() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("RouletteGame.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) idPlay.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }
}