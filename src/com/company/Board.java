package com.company;

public class Board {
    private Boolean isGameOver;


    public Board(Boolean isGameOver) {
        setIsGameOver(isGameOver);
    }


    public Integer checkIfGameWon(Square[] squares) {
        // passing in the array of square instances to be checked against horizonal, vertical and diagonal wins
        Integer horizontalWinner = checkHorizontalRows(squares);
        Integer verticalWinner = checkVerticalRows(squares);
        Integer diagonalWinner = checkDiagonalRows(squares);

        // the three methods will return either a 1(Player 1 Won) or 2(Player 2 won) which will return back to Main.java
       if (horizontalWinner != 0) {
           return horizontalWinner;
       } else if (verticalWinner != 0) {
           return verticalWinner;
       } else if (diagonalWinner != 0) {
           return diagonalWinner;
       } else {
           return 0;
       }
    }

    private Integer checkHorizontalRows(Square[] squares) {
        //gridcount  is used to check if each row has a matching symbol
        Integer gridCount = 1;
        // when checking every square in the row it'll append that squares symbol into winningString
        String winningString = "";
        Integer playerNumberWinner = 0;
        //iterating through each square checking if the square is already chosen, if so then append that squares symbol -
        // into winning string
        for (Integer x = 0; x <9; x++) {
            if (squares[x].getIsAlreadyChosen()) {
                winningString += squares[x].getInputSymbol();
            }
            // if the grid count is divisible by 3 (end of the row) reset the winning string for checking the next row
            if (gridCount % 3 == 0 ) {
                // the compareToWinningString method will return either a 1 or 2 if a won is met, and which player won
                playerNumberWinner = compareToWinningString(winningString);
                if (playerNumberWinner == 1 || playerNumberWinner == 2 ) {
                    return playerNumberWinner;
                }
                winningString = "";
            }
            // incrementing the grid count for every square
            gridCount += 1;
        }
        return playerNumberWinner;
    }

    private Integer checkVerticalRows(Square[] squares) {
        //gridcount  is used to check if each row has a matching symbol
        Integer gridCount = 1;
        String winningString = "";
        // when checking every square in the row it'll append that squares symbol into winningString
        Integer playerNumberWinner = 0;
        // since the squares were given ids horizontally when initialized, in order to check for a vertical -
        // winner, we use the for loop to iterate vertically through the square id's and check for the winner that way
        Integer[] squareOrder = {0,3,6,1,4,7,2,5,8};

        for (Integer x = 0; x < 9; x++) {
            Square square = squares[squareOrder[x]];
            if (square.getIsAlreadyChosen()) {
                winningString += square.getInputSymbol();
            }

            // reseeing the grid count if divisible by three
            if (gridCount % 3 == 0 ) {
              playerNumberWinner = compareToWinningString(winningString);
              if (playerNumberWinner == 1 || playerNumberWinner == 2 ) {
                  return playerNumberWinner;
              }
                winningString = "";
            }
            gridCount += 1;
        }
        return playerNumberWinner;
    }

    private Integer checkDiagonalRows(Square[] squares) {
        Integer gridCount = 1;
        String winningString = "";
        Integer playerNumberWinner = 0;
        // using the squareOrder array to index the square's diagonal Id's in order to check for matching symbols
        Integer[] squareOrder =  {0,4,8,2,4,6};
        for (Integer x = 0; x < 6; x++) {
            Square square = squares[squareOrder[x]];
            if (square.getIsAlreadyChosen()) {
                winningString += square.getInputSymbol();
            }
            // reset grid count if divisible by three
            if (gridCount % 3 == 0 ) {
                playerNumberWinner = compareToWinningString(winningString);
                if (playerNumberWinner == 1 || playerNumberWinner == 2 ) {
                    return playerNumberWinner;
                }
                winningString = "";
            }
            gridCount += 1;
        }
        return playerNumberWinner;
    }

    private Integer compareToWinningString(String winningString) {
        // the winning string gets a symbol appended to it each time a square is pressed,
        // when checking the winning string against XXX or OOO will determine if someone has won
        Integer playerNumberWinner = 0;
        if (winningString.equals("XXX")) {

            playerNumberWinner = 1;
        }
        if (winningString.equals("OOO")) {
            playerNumberWinner = 2;

        }
        return playerNumberWinner;
    }



    public Boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
