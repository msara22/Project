package Encryption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EncryptionController {

    @FXML
    private Label keyIn;

    @FXML
    private TextField keyInput;

    @FXML
    private TextField textInput;

    @FXML
    private Button encodeButton;

    @FXML
    private Button decodeButton;

    @FXML
    private TextField result;
    int modularMultiplicativeInverse(int keyInStr) {
        keyInStr = keyInStr % 26;
        for (int i = 1; i <= 26; i++) {
            if (keyInStr * i % 26 == 1) {
                return i;
            }
        }
        return 1;
    }

    int gcd(int number1, int number2) {
        if (number2 == 0)
            return number1;
        else
            return gcd(number2, number1 % number2);
    }

    @FXML
    void decode(ActionEvent event) {
        try{
            int keyInStr = Integer.parseInt(keyInput.getText());
            int keyInStr1 = Integer.parseInt(keyInput.getText());

            String textInt = textInput.getText();

            if (gcd(keyInStr1, 26) != 1) {
                throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
            }
            textInt = textInt.toLowerCase();
            textInt = textInt.replaceAll(" ", "");
            int MMI = modularMultiplicativeInverse(keyInStr);
            int fixedLength = 0;
            StringBuilder plaintext = new StringBuilder();
            for (int i = 0; i < textInt.length(); i++) {
                if (textInt.charAt(i) == ',' || textInt.charAt(i) == '.') {
                    continue;
                } else if (Character.isDigit(textInt.charAt(i))) {
                    plaintext.append(textInt.charAt(i));
                } else {
                    int y = textInt.charAt(i);
                    int result = (y - 97) - keyInStr1;
                    if (result < 0) {
                        while (result < 0) {
                            result = result + 26;
                        }
                    }
                    plaintext.append((char) (MMI * (result) % 26 + 97));
                }
            }
            result.setText(plaintext.toString());

        }
        catch(IllegalArgumentException e){
            keyInput.setText("Enter coprime number");
        }
        try{
            int keyInStr = Integer.parseInt(keyInput.getText());
            int keyInStr1 = Integer.parseInt(keyInput.getText());

            String textInt = textInput.getText();

            if (gcd(keyInStr1, 26) != 1) {
                throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
            }
            textInt = textInt.toLowerCase();
            textInt = textInt.replaceAll(" ", "");
            int MMI = modularMultiplicativeInverse(keyInStr);
            int fixedLength = 0;
            StringBuilder plaintext = new StringBuilder();
            for (int i = 0; i < textInt.length(); i++) {
                if (textInt.charAt(i) == ',' || textInt.charAt(i) == '.') {
                    continue;
                } else if (Character.isDigit(textInt.charAt(i))) {
                    plaintext.append(textInt.charAt(i));
                } else {
                    int y = textInt.charAt(i);
                    int result = (y - 97) - keyInStr1;
                    if (result < 0) {
                        while (result < 0) {
                            result = result + 26;
                        }
                    }
                    plaintext.append((char) (MMI * (result) % 26 + 97));
                }
            }
            result.setText(plaintext.toString());

        }
        catch(NumberFormatException e){
            keyInput.setText("Enter coprime number");
        }

    }

    @FXML
    void encode(ActionEvent event) {
        try{
            int keyInStr = Integer.parseInt(keyInput.getText());
            int keyInStr1 = Integer.parseInt(keyInput.getText());

            String textInt = textInput.getText();

            if (gcd(keyInStr, 26) != 1) {
                throw new IllegalArgumentException("Error: key A and alphabet size must be coprime.");
            }
            textInt = textInt.toLowerCase();
            textInt = textInt.replaceAll(" ", "");
            StringBuilder ciphertext = new StringBuilder();
            int fixedLength = 0;
            for (int i = 0; i < textInt.length(); i++) {
                if (textInt.charAt(i) == ',' || textInt.charAt(i) == '.') {
                    continue;
                } else if (fixedLength == 5) {
                    ciphertext.append(" ");
                    fixedLength = 0;
                    i--;
                } else if (Character.isDigit(textInt.charAt(i))) {
                    ciphertext.append(textInt.charAt(i));
                    fixedLength++;
                } else {
                    ciphertext.append((char) ((((textInt.charAt(i) - 97) * keyInStr + keyInStr1) % 26) + 97));
                    fixedLength++;
                }
            }
            result.setText(ciphertext.toString());
        }
        catch(IllegalArgumentException e){
            keyInput.setText("Enter coprime number");
        }


    }

}

