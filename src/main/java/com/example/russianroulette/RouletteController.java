package com.example.russianroulette;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RouletteController extends Transition {

    @FXML private TextField idNum1;
    @FXML private TextField idNum2;
    @FXML private TextField idNum3;
    @FXML private TextField idNum4;
    @FXML private TextField idNum5;
    @FXML private Button idShoot;
    @FXML private Button idRoll1;
    @FXML private Button idRoll2;
    @FXML private Button idFinish;
    @FXML private Button idContinue;
    @FXML private Button idNext;
    @FXML private ImageView idGun;
    @FXML private ImageView idArrayImage;
    @FXML private ImageView idDoubleKill;
    @FXML private TextField idNum6;
    @FXML private Text idName1;
    @FXML private Text idName2;
    @FXML private Label idX1;
    @FXML private Label idX2;
    @FXML private Label idX3;
    @FXML private Label idX4;
    @FXML private Label idX5;
    @FXML private Label idX11;
    @FXML private Label idX22;
    @FXML private Label idX33;
    @FXML private Label idX44;
    @FXML private Label idX55;
    @FXML private Label idQuestion;
    @FXML private Label idWinLose;

    int count = 1, deathP1 = 0, deathP2 = 0, countArray = 0;
    boolean player1 = true, player2 = false, Death = false;
    Random random = new Random();
    int randomNum = random.nextInt(6) + 1;
    int valueRoll = random.nextInt(6) + 1;

    public void initialize() {
        idContinue.setVisible(false);
    }
    public void imageSwitch() {
        if (player1) {
            File fileSx = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\RevolverSwitch.png");
            idGun.setImage(new Image(fileSx.toURI().toString()));
        } else {
            File fileDx = new File("C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\Images\\Revolver.png");
            idGun.setImage(new Image(fileDx.toURI().toString()));
        }
    }
    public void setNamePlayers(String name1, String name2){
        idName1.setText(name1);
        idName2.setText(name2);
    }
    public void boolValueDeath(boolean valueDeath){
        Death = valueDeath;
        if(Death){
            idWinLose.setText("Someone found my secret room...\nso i think i stop the game");
            idShoot.setVisible(false);
            idRoll1.setVisible(false);
            idRoll2.setVisible(false);
            sentenceAfterSecretRoom();
        }
    }
    public void sentenceAfterSecretRoom(){
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.play();
        pauseTransition.setOnFinished(event -> {
            idWinLose.setText("killing both of you...");
            PauseTransition pauseTransition1 = new PauseTransition(Duration.seconds(3));
            pauseTransition1.play();
            pauseTransition1.setOnFinished(event1 -> {
                transitionDoubleKill();
            });
        });
    }
    public void transitionDoubleKill(){
        idDoubleKill.setVisible(true);
        TranslateTransition transitionX = new TranslateTransition(Duration.seconds(0.5), idDoubleKill);
        transitionX.setFromX(0);
        transitionX.setToX(-150);
        transitionX.play();
        transitionX.setOnFinished(event -> {
            try {
                onFinishClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void greenBack(TextField textField) {
        playClick();
        transitionGun();
        textField.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

        if (count % 2 != 0 && player1) {
            player1 = false;
            player2 = true;
        } else {
            player1 = true;
            player2 = false;
        }
        count++;
    }
    public void redBack(TextField textField) {
        playShot();
        transitionGun();
        textField.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        idShoot.setVisible(false);
        if (player1) {
            deathP1++;
            if (deathP1 == 1) {
                idX1.setText("X");
            } else if (deathP1 == 2) {
                idX2.setText("X");
            } else if (deathP1 == 3) {
                idX3.setText("X");
            } else if (deathP1 == 4) {
                idX4.setText("X");
            } else if (deathP1 == 5) {
                idX5.setText("X");
            }
            idRoll1.setVisible(true);
        } else {
            deathP2++;
            if (deathP2 == 1) {
                idX11.setText("X");
            } else if (deathP2 == 2) {
                idX22.setText("X");
            } else if (deathP2 == 3) {
                idX33.setText("X");
            } else if (deathP2 == 4) {
                idX44.setText("X");
            } else if (deathP2 == 5) {
                idX55.setText("X");
            }
            idRoll2.setVisible(true);
        }
        finalDialogueBeforeWin();
    }
    public void onShootButton() {
        idShoot.setDisable(true);
        if (count == 1) {
            firstShoot();
        } else if (count == 2) {
            secondShoot();
        } else if (count == 3) {
            thirdShoot();
        } else if (count == 4) {
            fourthShoot();
        } else if (count == 5) {
            fiveShoot();
        } else if (count == 6) {
            sixthShoot();
        }
    }
    public void firstShoot() {
        if (randomNum == 1) {
            redBack(idNum1);
        } else greenBack(idNum1);
    }
    public void secondShoot() {
        if (randomNum == 2) {
            redBack(idNum2);
        } else greenBack(idNum2);
    }
    public void thirdShoot() {
        if (randomNum == 3) {
            redBack(idNum3);
        } else greenBack(idNum3);
    }
    public void fourthShoot() {
        if (randomNum == 4) {
            redBack(idNum4);
        } else greenBack(idNum4);
    }
    public void fiveShoot() {
        if (randomNum == 5) {
            redBack(idNum5);
        } else greenBack(idNum5);
    }
    public void sixthShoot() {
        if (randomNum == 6) {
            redBack(idNum6);
        } else greenBack(idNum6);
    }
    public void onNextClicked() {
        idNum1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        idNum2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        idNum3.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        idNum4.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        idNum5.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        idNum6.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        count = 1;
        idNext.setOpacity(0);
        idShoot.setVisible(true);
        randomNum = random.nextInt(6) + 1;
        player1 = true;
        player2 = false;
        imageSwitch();
    }
    public void onRoll1Clicked() {
        valueRoll = random.nextInt(6) + 1;
        System.out.println(valueRoll);
        setRestart();
        idNext.setVisible(true);
        if (valueRoll == 1 || valueRoll == 6) {
            docSxTransition();
            if (deathP1 == 1) {
                idX1.setText("-");
                deathP1--;
            } else if (deathP1 == 2) {
                idX2.setText("-");
                deathP1--;
            } else if (deathP1 == 3) {
                idX3.setText("-");
                deathP1--;
            } else if (deathP1 == 4) {
                idX4.setText("-");
                deathP1--;
            } else if (deathP1 == 5) {
                idX5.setText("-");
                deathP1--;
            }
        }
        idRoll1.setVisible(false);
        finalDialogueBeforeWin();
    }
    public void onRoll2Clicked() {
        valueRoll = random.nextInt(6) + 1;
        System.out.println(valueRoll);
        setRestart();
        idNext.setVisible(true);
        if (valueRoll == 1 || valueRoll == 6) {
            docDxTransition();
            if (deathP2 == 1) {
                idX11.setText("-");
                deathP2--;
            } else if (deathP2 == 2) {
                idX22.setText("-");
                deathP2--;
            } else if (deathP2 == 3) {
                idX33.setText("-");
                deathP2--;
            }else if (deathP2 == 4) {
                idX44.setText("-");
                deathP2--;
            }else if (deathP2 == 5) {
                idX55.setText("-");
                deathP2--;
            }
        }
        idRoll2.setVisible(false);
        finalDialogueBeforeWin();
    }
    public void startQuestion(int num){
        countArray += num;
        idArrayImage.setDisable(true);
        idContinue.setVisible(true);
        idShoot.setOpacity(0);
        if(num == 1){
            idQuestion.setText("Lost?" + "\n" + "When you're not here, the game restarts");
        } else if(num == 2){
            idQuestion.setText("Again? I don't want to waste my time" + "\n" + "so stay here");
        } else if(num == 3){
            idQuestion.setText("You're attracted to the keypad eh?" + "\n" + "It's broken, keep playing");
        } else if(num == 4){
            idQuestion.setText("You're annoying me" + "\n" + "I think i lock the room");
            idArrayImage.setVisible(false);
            lockDoorSound();
        }
    }
    public void finalDialogueBeforeWin() {
        if(idX5.getText().equals("X") || idX55.getText().equals("X")){
            idShoot.setVisible(false);
            idNext.setVisible(false);
            idFinish.setVisible(true);
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
            pauseTransition.play();
            pauseTransition.setOnFinished(event -> {
                idWinLose.setText("Someone lost");
                FadeTransition fadeTransitionFinish = new FadeTransition(Duration.seconds(1), idFinish);
                fadeTransitionFinish.setFromValue(0);
                fadeTransitionFinish.setToValue(1);
                fadeTransitionFinish.play();
            });
        }
    }
    public void onFinishClicked() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("BlackScene.fxml"));
        Parent root = fxmlLoader2.load();
        Stage stage2 = (Stage) idFinish.getScene().getWindow();
        stage2.setScene(new Scene(root, 700, 600));
    }
    public void switchToSecondRoom() throws IOException{
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("CodeRoom.fxml"));
        Parent root = fxmlLoader1.load();

        CodeRoom codeRoom = fxmlLoader1.getController();
        codeRoom.updateArrayCount(countArray);
        Stage stage1 = (Stage) idArrayImage.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }
    private void playShot() {
        String nameSong1 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\shot.mp3";
        Media soundShot = new Media(new File(nameSong1).toURI().toString());
        MediaPlayer mediaPlayerShot = new MediaPlayer(soundShot);
        mediaPlayerShot.setVolume(1);
        mediaPlayerShot.play();
    }
    private void playClick() {
        String nameSong2 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\click.mp3";
        Media soundClick = new Media(new File(nameSong2).toURI().toString());
        MediaPlayer mediaPlayerClick = new MediaPlayer(soundClick);
        mediaPlayerClick.setVolume(1);
        mediaPlayerClick.play();
    }
    public void transitionGun() {
        RotateTransition rotateTransition;
        if (player1) {
            rotateTransition = new RotateTransition(Duration.seconds(0.5), idGun);
            rotateTransition.setFromAngle(0);
            rotateTransition.setToAngle(20);
            rotateTransition.setFromAngle(20);
            rotateTransition.setToAngle(0);
        } else {
            rotateTransition = new RotateTransition(Duration.seconds(0.5), idGun);
            rotateTransition.setFromAngle(0);
            rotateTransition.setToAngle(-20);
            rotateTransition.setFromAngle(-20);
            rotateTransition.setToAngle(0);
        }
        rotateTransition.play();
        rotateTransition.setOnFinished(actionEvent -> {
            idShoot.setDisable(false);
            imageSwitch();
        });
    }
    public void onContinueClicked(){
        idQuestion.setVisible(false);
        idContinue.setVisible(false);
        idArrayImage.setDisable(false);
        FadeTransition fadeTransitionShot = new FadeTransition(Duration.seconds(0.5), idShoot);
        fadeTransitionShot.setFromValue(0);
        fadeTransitionShot.setToValue(1);
        fadeTransitionShot.play();
    }
    public void lockDoorSound(){
        String nameSong2 = "C:\\Users\\comet\\IdeaProjects\\RussianRoulette\\src\\main\\resources\\sounds\\lockDoor.mp3";
        Media soundLockDoor = new Media(new File(nameSong2).toURI().toString());
        MediaPlayer mediaPlayerLockDoor = new MediaPlayer(soundLockDoor);
        mediaPlayerLockDoor.setVolume(1);
        mediaPlayerLockDoor.play();
    }
}