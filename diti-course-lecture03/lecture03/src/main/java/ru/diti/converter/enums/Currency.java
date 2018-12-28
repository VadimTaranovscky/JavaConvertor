package ru.diti.converter.enums;
import javafx.scene.image.Image;
import java.awt.*;

public enum Currency {
    USD("/images/dollar.png"),
    RUR("/images/Rub.png"),
    EUR("/images/euro.png"),
    MXN("/images/pesso.png");

    private Image image;

    Currency(String string){
        this.image = new Image(string);
    }

    public Image getImage(){
        return this.image;
    }
}