package com.company;

public class Board {
    private Boolean isGameOver;


    public Board(Boolean isGameOver) {
        setIsGameOver(isGameOver);
    }

    public Boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
