package com.casperdaris;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EncryptieGUI {

    private Label text, key, uitvoer;
    private TextField textField, keyField, uitvoerField;
    private Button encryptButton;

    public EncryptieGUI(GridPane gui) {

        text = new Label("Voer hier je tekst in:");
        text.setFont(Font.font("SF Pro", 12));

        textField = new TextField();

        key = new Label("Key:");
        key.setFont(Font.font("SF Pro", 12));

        keyField = new TextField();

        uitvoer = new Label("Uitkomst:");
        uitvoer.setFont(Font.font("SF Pro", 12));

        uitvoerField = new TextField();

        encryptButton = new Button("Encrypt");
        encryptButton.setOnAction(event -> {

        });

        gui.add(text, 0, 0);
        gui.add(textField, 0, 1);
        gui.add(key, 1, 0);
        gui.add(keyField, 1, 1);
        gui.add(uitvoer, 0, 3);
        gui.add(uitvoerField, 0, 4);
        gui.add(encryptButton, 1, 4);
        gui.addRow(2, new Text(""));
        gui.addRow(5, new Text(""));
        gui.setHgap(12);
        gui.setVgap(12);
        gui.setPadding(new Insets(20, 20, 20, 20));
    }

}
