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
        Integer totalCount = 0;
        Integer gridCount = 1;
        for (Integer x = 0; x <9; x++) {
            System.out.println(squares[x].getNumber());

            if (squares[x].getIsAlreadyChosen()) {
                totalCount += squares[x].getMagicNumber();
                System.out.println(totalCount + "total count");
                if (totalCount == 15) {
                    System.out.println("Game Won ");
                }

                if (gridCount % 3 == 0 ) {
                    totalCount = 0;
                }

            }
            gridCount += 1;
        }
    }

    public Boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
