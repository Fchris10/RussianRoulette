package com.example.russianroulette;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteController {

    @FXML
    private TextField idPointP1;
    @FXML
    private TextField idPointP2;
    @FXML
    private TextField idNum1;
    @FXML
    private TextField idNum2;
    @FXML
    private TextField idNum3;
    @FXML
    private TextField idNum4;
    @FXML
    private TextField idNum5;
    @FXML
    private Button idShoot;
    @FXML
    private Button idRestart;
    @FXML
    private TextField idNum6;

    int count = 1, pointPlayer1 = 0, pointPlayer2 = 0;
    boolean player1 = true;
    boolean player2 = false;
    Random random = new Random();
    int randomNum = random.nextInt(6) + 1;
    public void greenBack(TextField textField){
        textField.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        if(count%2 != 0){
            player1 = false;
            player2 = true;
        } else{
            player1 = true;
            player2 = false;
        }
        count++;
    }
    public void redBack(TextField textField){
        textField.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        idShoot.setDisable(true);
        if(player1){
            pointPlayer2++;
            idPointP2.setText(String.valueOf(pointPlayer2));
        } else{
            pointPlayer1++;
            idPointP1.setText(String.valueOf(pointPlayer1));
        }
        idRestart.setOpacity(1);
    }
    public void onShootButton() {
        if(count == 1){
            firstShoot();
        } else if(count == 2){
            secondShoot();
        } else if(count == 3){
            thirdShoot();
        } else if(count == 4){
            fourthShoot();
        } else if(count == 5){
            fiveShoot();
        } else if(count == 6){
            sixthShoot();
        }
    }
    public void firstShoot(){
        if(randomNum == 1){
            redBack(idNum1);
        } else greenBack(idNum1);
    }
    public void secondShoot(){
        if(randomNum == 2){
            redBack(idNum2);
        } else greenBack(idNum2);
    }
    public void thirdShoot(){
        if(randomNum == 3){
            redBack(idNum3);
        } else greenBack(idNum3);
    }
    public void fourthShoot(){
        if(randomNum == 4){
            redBack(idNum4);
        } else greenBack(idNum4);
    }
    public void fiveShoot(){
        if(randomNum == 5){
            redBack(idNum5);
        } else greenBack(idNum5);
    }
    public void sixthShoot(){
        if(randomNum == 6){
            redBack(idNum6);
        } else greenBack(idNum6);
    }
    public void onRestartClicked() {
        idNum1.setBackground(null);
        idNum2.setBackground(null);
        idNum3.setBackground(null);
        idNum4.setBackground(null);
        idNum5.setBackground(null);
        idNum6.setBackground(null);
        count = 1;
        idRestart.setOpacity(0);
        idShoot.setDisable(false);
        randomNum = random.nextInt(6) + 1;
    }
}