package br.com.cod3r.calc.view;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text, Color color){
        setText(text);
        setOpaque(true);
        setBackground(color);
        setForeground(Color.white);
        setFont(new Font("courier",Font.PLAIN,25));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }
}
