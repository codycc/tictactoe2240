package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        //these will be for the grid
        //buttons don't currently do anything, this is just to make sure the grid works
        GridPane grid = new GridPane();
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        button1.setPrefSize(300,300);
        button2.setPrefSize(300,300);
        button3.setPrefSize(300,300);
        button4.setPrefSize(300,300);
        button5.setPrefSize(300,300);
        button6.setPrefSize(300,300);
        button7.setPrefSize(300,300);
        button8.setPrefSize(300,300);
        button9.setPrefSize(300,300);
        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.add(button1, 0, 0);
        grid.add(button2, 1, 0);
        grid.add(button3, 2, 0);
        grid.add(button4, 0, 1);
        grid.add(button5, 1, 1);
        grid.add(button6, 2, 1);
        grid.add(button7, 0, 2);
        grid.add(button8, 1, 2);
        grid.add(button9, 2, 2);
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class BoardStart{
    //this pane should pop up when the game starts, and will take user names
    //not 100% sure where to put them yet
    //Pane pane = new Pane();
    //TextField userName = new TextField();
    //Label label1 = new Label("Player 1, please enter your name");
    //Label label2 = new Label("Player 2, please enter your name");
    //Button ok = new Button("OK");
    String playerName;
    String playerName2;
    //insert code for setting each player's name
    User player1 = new User(true, playerName, "X");
    User player2 = new User(false, playerName2, "O");
    Board board = new Board(false);
    Canvas canvas = new Canvas();
    Tile tile = new Tile(false, 5);
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
