package com.company;

public class User {
    private Boolean isCurrentTurn;
    private String name;
    private String symbol;


    public User(Boolean isCurrentTurn, String name, String symbol) {
        isCurrentTurn = isCurrentTurn;
        name = name;
        symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Boolean getIsCurrentTurn() {
        return this.isCurrentTurn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setIsCurrentTurn(Boolean isCurrentTurn) {
        this.isCurrentTurn = isCurrentTurn;
    }


}
