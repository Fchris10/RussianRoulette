package com.example.russianroulette;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;

public class Paper {
    @FXML private ImageView idArrayBack;

    public void onArrayBackClicked() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("CodeRoom.fxml"));
        Parent root = fxmlLoader1.load();
        Stage stage1 = (Stage) idArrayBack.getScene().getWindow();
        stage1.setScene(new Scene(root, 700, 600));
    }
}