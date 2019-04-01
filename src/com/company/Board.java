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
        Integer userTallyCount = 0;
        for (Integer x = 0; x <9; x++) {
            System.out.println(squares[x].getNumber());



            if (squares[x].getIsAlreadyChosen()) {
                userTallyCount += squares[x].getInputNumber();
                System.out.println(userTallyCount + "tally");
            }

            if (gridCount % 3 == 0 ) {
                System.out.println(gridCount + "grid count");
                if (userTallyCount == 3) {
                    System.out.println("Player 1 Won");
                }
                if (userTallyCount == 6) {
                    System.out.println("Player 2 Won");
                }
                userTallyCount = 0;
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
