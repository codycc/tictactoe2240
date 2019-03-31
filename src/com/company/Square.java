package com.company;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.awt.*;

public class Square extends StackPane {
    private Boolean isAlreadyChosen;
    private Integer number;
    private String content;


    public Square(Boolean isAlreadyChosen, Integer number, String content) {
        setIsAlreadyChosen(isAlreadyChosen);
        setNumber(number);
        setContent(content);
        Rectangle border = new Rectangle(300,300);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        getChildren().addAll(border);
    }


    public Boolean getIsAlreadyChosen() {
        return this.getIsAlreadyChosen();
    }

    public String getContent() {
        return this.content;
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

    public void setContent(String content) {
        this.content = content;
    }
}
