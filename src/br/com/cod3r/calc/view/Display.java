package br.com.cod3r.calc.view;

import br.com.cod3r.calc.model.Memory;
import br.com.cod3r.calc.model.ObserverMemomy;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements ObserverMemomy {
    private JLabel label;
    public Display(){
        Memory.getInstance().addObserver(this);

        setBackground(Color.black);
        label = new JLabel(Memory.getInstance().getActualText());
        label.setForeground(Color.white);
        label.setFont(new Font("courier", Font.PLAIN,30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10,25));

        add(label);
    }


    @Override
    public void valueChanged(String newValue) {
        label.setText(newValue);
    }
}
