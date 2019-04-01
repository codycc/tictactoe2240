package com.company;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.ButtonType;

import java.awt.*;

public class Square extends StackPane {
    private Boolean isAlreadyChosen;
    private Integer number;
    private Integer inputNumber;
    private Text text = new Text();



    public Square(Boolean isAlreadyChosen, Integer number, Integer inputNumber) {
        setIsAlreadyChosen(isAlreadyChosen);
        setNumber(number);
        setInputNumber(inputNumber);
        Rectangle border = new Rectangle(300,300);
        border.setFill(null);
        text.setFont(Font.font(68));
        border.setStroke(Color.BLACK);
        getChildren().addAll(border,text);
    }


    public void displayUserSymbol(String symbol) {
        text.setText(symbol);
    }


    public Boolean getIsAlreadyChosen() {
        return this.isAlreadyChosen;
    }

    public Integer getInputNumber() {
        return this.inputNumber;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setIsAlreadyChosen(Boolean isAlreadyChosen) {
        this.isAlreadyChosen = isAlreadyChosen;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setInputNumber(Integer magicNumber) {
        this.inputNumber = magicNumber;
    }
}
