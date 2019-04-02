package com.company;

public class User {
    private Boolean isCurrentTurn;
    private String name;
    private String symbol;
    private Integer inputNumber;

    //constructor for user
    public User(Boolean isCurrentTurn, String name, String symbol, Integer inputNumber) {
        setIsCurrentTurn(isCurrentTurn);
        setInputNumber(inputNumber);
        setName(name);
        setSymbol(symbol);
    }

    // getters
    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Boolean getIsCurrentTurn() {
        return this.isCurrentTurn;
    }

    public Integer getInputNumber() {
        return this.inputNumber;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setIsCurrentTurn(Boolean isCurrentTurn) {
        this.isCurrentTurn = isCurrentTurn;
    }

    public void setInputNumber(Integer inputNumber) {
        this.inputNumber = inputNumber;
    }

}
