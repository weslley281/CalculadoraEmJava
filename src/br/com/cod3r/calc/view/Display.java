package br.com.cod3r.calc.view;

import br.com.cod3r.calc.model.Memory;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private JLabel label;
    public Display(){
        setBackground(Color.black);
        label = new JLabel(Memory.getInstance().getActualText());
        label.setForeground(Color.white);
        label.setFont(new Font("courier", Font.PLAIN,30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10,25));

        add(label);
    }
}
