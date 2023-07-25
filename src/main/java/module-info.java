module fulopbence.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens fulopbence.tictactoe to javafx.fxml;
    exports fulopbence.tictactoe;
}