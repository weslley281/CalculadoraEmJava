package br.com.cod3r.calc.view;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel {
    private final Color darkGray = new  Color(54,54,54);
    private final Color dimGray = new  Color(105,105,105);
    private final Color darkBlue = new  Color(0,0,205);
    public Keyboard(){
        setBackground(Color.darkGray);
        setLayout(new GridLayout(5,4));
        add(new CustomButton("AC", darkGray));
        add(new CustomButton("+/-", darkGray));
        add(new CustomButton("%", darkGray));
        add(new CustomButton("/", darkBlue));

        add(new CustomButton("7", dimGray));
        add(new CustomButton("8", dimGray));
        add(new CustomButton("9", dimGray));
        add(new CustomButton("*", darkBlue));

        add(new CustomButton("4", dimGray));
        add(new CustomButton("5", dimGray));
        add(new CustomButton("6", dimGray));
        add(new CustomButton("*", darkBlue));

        add(new CustomButton("1", dimGray));
        add(new CustomButton("2", dimGray));
        add(new CustomButton("3", dimGray));
        add(new CustomButton("*", darkBlue));
    }
}
