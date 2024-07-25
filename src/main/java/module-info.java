module com.example.russianroulette {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;



    opens com.example.russianroulette to javafx.fxml;
    exports com.example.russianroulette;



}