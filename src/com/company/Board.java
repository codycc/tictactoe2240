package com.company;

public class Board {
    private Boolean isGameOver;


    public Board(Boolean isGameOver) {
        setIsGameOver(isGameOver);
    }



    public Boolean checkIfGameWon(Square[] squares, User user) {


        checkHorizontalRows(squares);
        return true;
    }

    public Boolean checkHorizontalRows(Square[] squares) {
        Integer gridCount = 1;
        String winningString = "";
        for (Integer x = 0; x <9; x++) {
            if (squares[x].getIsAlreadyChosen()) {
                winningString += squares[x].getInputSymbol();
                System.out.println(winningString + "tally");
            }

            if (gridCount % 3 == 0 ) {
                System.out.println(gridCount + "grid count");
                if (winningString.equals("XXX")) {
                    System.out.println("Player 1 Won");
                }
                if (winningString.equals("OOO")) {
                    System.out.println("Player 2 Won");
                }
                winningString = "";
            }

            gridCount += 1;
        }
        return true;
    }

    public Boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
