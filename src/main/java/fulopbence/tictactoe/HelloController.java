package fulopbence.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

    private int playerTurn = 0;

    ArrayList<Button> buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
        checkIfGameIsOver();
    }

    public void checkIfGameIsOver(){
        boolean win = false;
        String[] players= {"X","O"};
        for(int i = 0; i<2; i++) {
            for (int a = 0; a < 8; a++) {
                //winner
                if (button1.getText() == players[i] && button2.getText() == players[i] && button3.getText() == players[i]) {
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button4.getText() == players[i] && button5.getText() == players[i] && button6.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button7.getText() == players[i] && button8.getText() == players[i] && button9.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button1.getText() == players[i] && button4.getText() == players[i] && button7.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button2.getText() == players[i] && button5.getText() == players[i] && button8.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button3.getText() == players[i] && button6.getText() == players[i] && button9.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button1.getText() == players[i] && button5.getText() == players[i] && button9.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }else if(button3.getText() == players[i] && button5.getText() == players[i] && button7.getText() == players[i]){
                    winnerText.setText(players[i] + " wins!");
                    win = true;
                }
            }
        }
        if(win){
            buttons.forEach(button ->{
                setupButton(button);
                button.setDisable(true);
            });
            }
    }
}