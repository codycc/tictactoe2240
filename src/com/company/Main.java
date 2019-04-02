package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import java.awt.*;

public class Main extends Application {
    // creating the main tic tac toe gridpane
    private GridPane createGrid(User player1, User player2, Stage primaryStage) {
        int offset = 300;
        int count = 0;
        Square[] squares = new Square[9];
        GridPane grid = new GridPane();

        grid.setPrefSize(900,900);
        Board gameBoard = new Board(false);

        // using two for loops to create the square instances and place them within the grid
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                // setting the square instance
                Square square = new Square(false, count, "");
                // adding the square to the squares array to be using in checking for the winner
                squares[count] = square;
                // using the offset to display squares on grid, ie x = 1, 1*300 = 300 , x = 2 2* 300 = 600 to layout the squares
                square.setTranslateY(x * offset);
                square.setTranslateX(y * offset);
                grid.getChildren().add(square);
                count += 1 ;
                // adding the click event for each square
                square.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // if the square isn't already chosen and it's the players turn then place the -
                        // users symbol and switch turns
                        if (player1.getIsCurrentTurn() && !square.getIsAlreadyChosen()  ) {
                            player1.setIsCurrentTurn(false);
                            player2.setIsCurrentTurn(true);
                            square.displayUserSymbol(player1.getSymbol());
                            square.setInputSymbol(player1.getSymbol());
                        } else if (player2.getIsCurrentTurn() && !square.getIsAlreadyChosen() )  {
                            player2.setIsCurrentTurn(false);
                            player1.setIsCurrentTurn(true);
                            square.displayUserSymbol(player2.getSymbol());
                            square.setInputSymbol(player2.getSymbol());
                        }
                        // set the square to be chosen since it's been clicked
                        square.setIsAlreadyChosen(true);
                        // checking if the game has been won, depending who the winner is, it'll create a pane with that users name
                        Integer winner = gameBoard.checkIfGameWon(squares);
                        if (winner == 1) {
                            primaryStage.setScene(new Scene(BoardWon(player1)));
                        } else if (winner == 2) {
                            primaryStage.setScene(new Scene(BoardWon(player2)));
                        }
                    }
                });
            }
        }
        return grid;
    }

    // creating the gridpane to display who the winning user is
    private GridPane BoardWon(User winningPlayer) {
        GridPane pane = new GridPane();
        Label winnerLabel = new Label("Congrats" + winningPlayer.getName());
        pane.add(winnerLabel,0,0);
        return pane;
    }

    // creating the gridpane for the beginning of the game, which will take in a users name
    private GridPane BoardStart(Stage primaryStage) {
        GridPane pane = new GridPane();
        //TextField userName = new TextField();
        Label player1Lbl = new Label("Player 1, please enter your name");
        Label player2Lbl = new Label("Player 2, please enter your name");
        TextField player1Txt = new TextField();
        TextField player2Txt = new TextField();
        Button startButton = new Button("OK");

        startButton.setOnAction(e -> {
            User player1 = new User(true, player1Txt.getText(), "X", 1);
            User player2 = new User(false, player2Txt.getText(), "O",2);
            primaryStage.setScene(new Scene(createGrid(player1,player2, primaryStage)));
            primaryStage.show();
        });

        pane.add(player1Lbl, 0,0);
        pane.add(player1Txt, 1,0);
        pane.add(player2Lbl, 0,1);
        pane.add(player2Txt, 1,1);
        pane.add(startButton,0,2);
        return pane;
    }


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(new Scene(BoardStart(primaryStage)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


