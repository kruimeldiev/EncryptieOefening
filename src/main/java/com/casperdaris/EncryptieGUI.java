package com.casperdaris;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EncryptieGUI {

    private Label invoer, key, uitvoer;
    private TextField invoerField, keyField, uitvoerField;
    private Button encryptButton, decryptButton;

    public EncryptieGUI(GridPane gui) {

        invoer = new Label("Voer hier je tekst in:");
        invoer.setFont(Font.font("SF Pro", 12));
        invoerField = new TextField();

        key = new Label("Key:");
        key.setFont(Font.font("SF Pro", 12));
        keyField = new TextField();

        // Deze Listener zorgt ervoor dat alleen nummers kunnen worden ingevoerd in de keyField
        // De listener kijkt naar de nieuwe ingevoerde value (input), wanneer deze geen cijfer is (\\d*), dan wordt de input vervangen door een lege String
        keyField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    keyField.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });

        uitvoer = new Label("Uitkomst:");
        uitvoer.setFont(Font.font("SF Pro", 12));
        uitvoerField = new TextField();

        encryptButton = new Button("Encrypt");
        encryptButton.setOnAction(event -> {

            if(!invoerField.getText().isEmpty()) {

                // Key maken voor de encryptie
                int key = 0;
                if (!keyField.getText().isEmpty()) {
                    key = Integer.parseInt(keyField.getText());
                }

                ByteEncryption crypto = new ByteEncryption();

                String data = invoerField.getText();
                String enc = new String(crypto.encrypt(data.getBytes(), key));

                uitvoerField.setText(enc);
                invoerField.clear();
            }
        });

        decryptButton = new Button("Decrypt");
        decryptButton.setOnAction(event -> {
            if (!uitvoerField.getText().isEmpty()) {

                int key = 0;
                if (!keyField.getText().isEmpty()) {
                    key = Integer.parseInt(keyField.getText());
                }

                ByteEncryption crypto = new ByteEncryption();

                String data = uitvoerField.getText();
                String dec = new String(crypto.decrypt(data.getBytes(), key));

                invoerField.setText(dec);
                uitvoerField.clear();
            }
        });

        gui.add(invoer, 0, 0);
        gui.add(invoerField, 0, 1);
        gui.add(key, 1, 0);
        gui.add(keyField, 1, 1);
        gui.add(uitvoer, 0, 3);
        gui.add(uitvoerField, 0, 4);
        gui.add(new HBox(12, encryptButton, decryptButton), 1, 4);
        gui.addRow(2, new Text(""));
        gui.addRow(5, new Text(""));
        gui.setHgap(12);
        gui.setVgap(12);
        gui.setPadding(new Insets(20, 20, 20, 20));
    }

}
