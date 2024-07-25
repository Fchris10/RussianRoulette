package com.example.russianroulette;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CodeRoom {
     @FXML private ImageView idDoor, idPaper, idBack;
     @FXML private Label id1, id2, id3, id4, idOk;

     int countClickNumbers = 0, clickForArrayCounter = 0, retry = 0;
     Integer[] arrCode = new Integer[4];
     Integer[] code = {1, 0, 0, 9};
     boolean valueCode = false;

    public void doorSoundEffect(){
        String nameSongStart = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\door.mp3";
        Media soundStart = new Media(new File(nameSongStart).toURI().toString());
        MediaPlayer mediaPlayerStart = new MediaPlayer(soundStart);
        mediaPlayerStart.play();
        mediaPlayerStart.setVolume(0.5);
    }
     public void onN0Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
          id1.setText("0");
          arrCode[0] = 0;
     } else if(countClickNumbers == 2){
          id2.setText("0");
          arrCode[1] = 0;
     } else if(countClickNumbers == 3){
          id3.setText("0");
          arrCode[2] = 0;
     } else if(countClickNumbers == 4){
          id4.setText("0");
          arrCode[3] = 0;
          checkCode();
     }
   }
   public void onN1Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("1");
             arrCode[0] = 1;
     } else if(countClickNumbers == 2){
             id2.setText("1");
             arrCode[1] = 1;
     } else if(countClickNumbers == 3){
             id3.setText("1");
             arrCode[2] = 1;
     } else if(countClickNumbers == 4){
             id4.setText("1");
             arrCode[3] = 1;
             checkCode();
     }
   }
   public void onN2Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("2");
             arrCode[0] = 2;
     } else if(countClickNumbers == 2){
             id2.setText("2");
             arrCode[1] = 2;
     } else if(countClickNumbers == 3){
             id3.setText("2");
             arrCode[2] = 2;
     } else if(countClickNumbers == 4){
             id4.setText("2");
             arrCode[3] = 2;
             checkCode();
     }
   }
   public void onN3Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("3");
             arrCode[0] = 3;
     } else if(countClickNumbers == 2){
             id2.setText("3");
             arrCode[1] = 3;
     } else if(countClickNumbers == 3){
             id3.setText("3");
             arrCode[2] = 3;
     } else if(countClickNumbers == 4){
             id4.setText("3");
             arrCode[3] = 3;
             checkCode();
     }
   }
   public void onN4Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("4");
             arrCode[0] = 4;
     } else if(countClickNumbers == 2){
             id2.setText("4");
             arrCode[1] = 4;
     } else if(countClickNumbers == 3){
             id3.setText("4");
             arrCode[2] = 4;
     } else if(countClickNumbers == 4){
             id4.setText("4");
             arrCode[3] = 4;
             checkCode();
     }
   }
   public void onN5Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("5");
             arrCode[0] = 5;
     } else if(countClickNumbers == 2){
             id2.setText("5");
             arrCode[1] = 5;
     } else if(countClickNumbers == 3){
             id3.setText("5");
             arrCode[2] = 5;
     } else if(countClickNumbers == 4){
             id4.setText("5");
             arrCode[3] = 5;
             checkCode();
     }
   }
   public void onN6Clicked() {
     countClickNumbers++;
     soundBeepButtons();
     if(countClickNumbers == 1){
             id1.setText("6");
             arrCode[0] = 6;
     } else if(countClickNumbers == 2){
             id2.setText("6");
             arrCode[1] = 6;
     } else if(countClickNumbers == 3){
             id3.setText("6");
             arrCode[2] = 6;
     } else if(countClickNumbers == 4){
             id4.setText("6");
             arrCode[3] = 6;
             checkCode();
     }
   }
   public void onN7Clicked() {
       countClickNumbers++;
       soundBeepButtons();
       if (countClickNumbers == 1) {
           id1.setText("7");
           arrCode[0] = 7;
       } else if (countClickNumbers == 2) {
           id2.setText("7");
           arrCode[1] = 7;
       } else if (countClickNumbers == 3) {
           id3.setText("7");
           arrCode[2] = 7;
       } else if (countClickNumbers == 4) {
           id4.setText("7");
           arrCode[3] = 7;
           checkCode();
       }
   }
   public void onN8Clicked() {
       countClickNumbers++;
       soundBeepButtons();
       if (countClickNumbers == 1) {
           id1.setText("8");
           arrCode[0] = 8;
       } else if (countClickNumbers == 2) {
           id2.setText("8");
           arrCode[1] = 8;
       } else if (countClickNumbers == 3) {
           id3.setText("8");
           arrCode[2] = 8;
       } else if (countClickNumbers == 4) {
           id4.setText("8");
           arrCode[3] = 8;
           checkCode();
       }
   }
   public void onN9Clicked() {
   countClickNumbers++;
   soundBeepButtons();
   if(countClickNumbers == 1){
           id1.setText("9");
           arrCode[0] = 9;
   } else if(countClickNumbers == 2){
           id2.setText("9");
           arrCode[1] = 9;
   } else if(countClickNumbers == 3){
           id3.setText("9");
           arrCode[2] = 9;
   } else if(countClickNumbers == 4){
           id4.setText("9");
           arrCode[3] = 9;
           checkCode();
           }
   }
   public void checkCode(){
       int c = 0;
        for(int i = 0; i < arrCode.length; i++){
            if(arrCode[i].equals(code[i])){
                c++;
            }
        } if(c == 4){
            valueCode = true;
        }
   }
   public void onOkClicked(){
       soundBeepButtons();
        if(valueCode){
           doorSoundEffect();
           File fileDoor = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\openDoor.png");
           idDoor.setImage(new Image(fileDoor.toURI().toString()));
           idDoor.setDisable(false);
       }
   }
    public void onRetryClicked() {
       retry++;
        if(retry == 2){
           id1.setVisible(false);
           id2.setVisible(false);
           id3.setVisible(false);
           id4.setVisible(false);
           idOk.setDisable(true);
       }
        id1.setText(" ");
        id2.setText(" ");
        id3.setText(" ");
        id4.setText(" ");
        countClickNumbers = 0;
        soundBeepButtons();
    }
    public void updateArrayCount(int num){
       num++;
       clickForArrayCounter = num;
    }
    public void soundBeepButtons(){
        String nameBeep = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\beep.mp3";
        Media soundBeep = new Media(new File(nameBeep).toURI().toString());
        MediaPlayer mediaPlayerBeep = new MediaPlayer(soundBeep);
        mediaPlayerBeep.setVolume(1);
        mediaPlayerBeep.play();
    }
    public void onBackClicked() throws IOException{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("RouletteGame.fxml"));
            Parent root = fxmlLoader1.load();

            RouletteController rouletteController = fxmlLoader1.getController();
            rouletteController.startQuestion(clickForArrayCounter);

            Stage stage1 = (Stage) idBack.getScene().getWindow();
            stage1.setScene(new Scene(root, 700, 600));
    }
    public void onDoorClicked(MouseEvent mouseEvent) throws IOException{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("SecretRoom.fxml"));
            Parent root = fxmlLoader1.load();
            Stage stage1 = (Stage) idDoor.getScene().getWindow();
            stage1.setScene(new Scene(root, 700, 600));
    }
    public void onPiperClicked() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Paper.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) idPaper.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }
}