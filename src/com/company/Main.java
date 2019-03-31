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
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;


import java.awt.*;

public class Main extends Application {




    private GridPane createGrid(User player1, User player2) {
        int offset = 300;
        int count = 1;
        GridPane grid = new GridPane();

        grid.setPrefSize(900,900);

        // creating square instances and setting them in the grid
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Square square = new Square(false, count, "");
                count += 1;
                square.setTranslateY(y * offset);
                square.setTranslateX(x * offset);
                grid.getChildren().add(square);
                System.out.println("Age: " + square.getNumber());
                square.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
//                        System.out.println(square.getNumber());
                        if (player1.getIsCurrentTurn()) {
                            player1.setIsCurrentTurn(false);
                            player2.setIsCurrentTurn(true);
                            square.displayO();
                        } else {
                            player2.setIsCurrentTurn(false);
                            player1.setIsCurrentTurn(true);
                            square.displayX();
                        }   

                    }
                });

            }
        }

        // setting labels
//        Label player1Lbl = new Label(player1.getName());
//        Label player2Lbl = new Label(player2.getName());
//        grid.add(player1Lbl,0,0);
//        grid.add(player2Lbl,1,0);
        return grid;
    }

    private GridPane BoardStart(Stage primaryStage) {
        GridPane pane = new GridPane();
        //TextField userName = new TextField();
        Label player1Lbl = new Label("Player 1, please enter your name");
        Label player2Lbl = new Label("Player 2, please enter your name");
        TextField player1Txt = new TextField();
        TextField player2Txt = new TextField();
        Button startButton = new Button("OK");

        startButton.setOnAction(e -> {
            User player1 = new User(true, player1Txt.getText(), "X");
            User player2 = new User(false, player2Txt.getText(), "O");
            primaryStage.setScene(new Scene(createGrid(player1,player2)));
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
        //these will be for the grid
        //buttons don't currently do anything, this is just to make sure the grid works
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(new Scene(BoardStart(primaryStage)));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}




//the commented methods should go somewhere
/* need to include a handler method for each button, or even better, a handler for all 9 buttons!
    public void setTileSymbol(){
        if (Tile.getIsAlreadyChosen() == false){
            if (player1.getIsCurrentTurn() == true){
              button.setLabel(player1.getSymbol());
            }
            else if (player2.getIsCurrentTurn() == true){
                button.setLabel(player2.getSymbol());
            }
        }
    }
*/
/* public void turnEnd(){
    if (gameOver() == true){
        //displays a message that indicates the turn player wins
        if (player1.getIsCurrentTurn == true){
            //insert victory message here
        }
        else if (player2.getIsCurrentTurn == true){
            //insert victory message here
        }
    }
    else{
        if (player1.getIsCurrentTurn() == true){
            player1.setIsCurrentTurn(false);
            player2.setIsCurrentTurn(true);
        }
        else if (player2.getIsCurrentTurn() == true){
            player2.setIsCurrentTurn(false);
            player1.setIsCurrentTurn(true);
        }
    }
}
 */
/*
//the turn player wins
public boolean playerWins(){
    boolean gameOver;
    if (player's score == 15){
        Board.setIsGameOver(true);
    return gameOver;
    }
}
*/
