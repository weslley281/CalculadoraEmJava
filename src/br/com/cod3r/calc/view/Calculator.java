package br.com.cod3r.calc.view;

import javax.swing.*;

public class Calculator extends JFrame {
    public Calculator(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(232,322);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
