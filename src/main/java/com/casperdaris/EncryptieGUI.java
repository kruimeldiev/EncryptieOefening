package com.casperdaris;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EncryptieGUI {

    private Label invoer, key, uitvoer;
    private TextField invoerField, keyField, uitvoerField;
    private Button encryptButton;

    public EncryptieGUI(GridPane gui) {

        invoer = new Label("Voer hier je tekst in:");
        invoer.setFont(Font.font("SF Pro", 12));

        invoerField = new TextField();

        key = new Label("Key:");
        key.setFont(Font.font("SF Pro", 12));

        keyField = new TextField();

        // Deze Listner zorgt ervoor dat alleen nummers kunnen worden ingevoerd in de keyField
        // De listner kijkt naar de nieuwe ingevoerde value (input), wanneer deze geen cijfer is (\\d*), dan wordt de input vervangen door een lege String
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
        uitvoerField.setEditable(false);

        encryptButton = new Button("Encrypt");
        encryptButton.setOnAction(event -> {

            // Eerst een key maken van de gebruiker input
            Integer keyInt = 0;
            if (!keyField.getText().isEmpty()) {
                keyInt = Integer.parseInt(keyField.getText());
            }

            // Vervolgens een CharArray maken van de input tekst
            char[] chars = invoerField.getText().toCharArray();

            // Nieuwe (lege) String maken
            String encryptedString = "";

            // De key Integer toegoegen aan iedere character in de CharArray en vervolgens deze character toevoegen aan de encryptedString
            for(char c : chars) {
                c += keyInt;
                encryptedString += c;
            }

            // Encrypted tekst weergeven voor de gebbruiker
            uitvoerField.setText(encryptedString);
        });

        gui.add(invoer, 0, 0);
        gui.add(invoerField, 0, 1);
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
