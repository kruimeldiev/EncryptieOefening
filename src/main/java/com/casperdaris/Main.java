package com.casperdaris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX Encryptie App
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Label aanmaken om de java(FX) versie te tonen in de GUI
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var versionLabel = new Label("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        versionLabel.setPadding(new Insets(6, 6, 6, 20));

        // GridPane aanmaken met de GUI
        GridPane gui = new GridPane();
        new EncryptieGUI(gui);

        // Scene aanmaken om de GUI en label samen weer te geven
        var scene = new Scene(new VBox(gui, versionLabel));

        // Stage opvullen met de Scene
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Java Encryptie Casper Daris");
    }

    public static void main(String[] args) {
        launch();
    }

}