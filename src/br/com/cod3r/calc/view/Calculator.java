package br.com.cod3r.calc.view;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    public Calculator(){
        defineLayout();
        //setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(232,322);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void defineLayout() {
        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
