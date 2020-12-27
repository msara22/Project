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

    @FXML
    void encode(ActionEvent event) {
        try{
            int keyInStr = Integer.parseInt(keyInput.getText());

            String textInt = textInput.getText();

            StringBuilder stb = new StringBuilder();
            char[] charList = textInt.toCharArray();
            int k = 0;
            for (int i = 0; i < charList.length; i++) {
                if ((charList[i] >= 'a') && (charList[i] <= 'z')) {
                    stb.append((char) updatePosition('a', charList[i], keyInStr));
                } else if ((charList[i] >= 'A') && (charList[i] <= 'Z')) {
                    stb.append((char) updatePosition('A', charList[i], keyInStr));
                } else {
                    stb.append(charList[i]);
                }
            }
            result.setText(stb.toString());
        }
        catch (NumberFormatException e){
            keyInput.setText("Input number");
        }


    }

    int updatePosition(char sChar, char cChar, int keyInStr) {
        int position = cChar - sChar;
        int updatedPosition = (position + keyInStr) % 26;
        return sChar + updatedPosition;
    }
    int updatePosition1(char sChar, char cChar, int keyInStr) {
        int position = cChar - sChar;
        int updatedPosition = Math.abs((position - keyInStr)) % 26;
        return sChar + updatedPosition;
    }

    @FXML
    void decode(ActionEvent event) {
        try{
            int keyInStr = Integer.parseInt(keyInput.getText());

            String textInt = textInput.getText();
            StringBuilder stb = new StringBuilder();
            char[] charList = textInt.toCharArray();
            int k = 0;
            for (int i = 0; i < charList.length; i++) {
                if ((charList[i] >= 'a') && (charList[i] <= 'z')) {
                    stb.append((char) updatePosition1('a', charList[i], keyInStr));
                } else if ((charList[i] >= 'A') && (charList[i] <= 'Z')) {
                    stb.append((char) updatePosition1('A', charList[i], keyInStr));
                } else {
                    stb.append(charList[i]);
                }
            }

            result.setText(stb.toString());

        }
        catch(NumberFormatException e){
            textInput.setText("Enter number");
        }

    }

}
