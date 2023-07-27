package br.com.cod3r.calc.view;

import br.com.cod3r.calc.model.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keyboard extends JPanel implements ActionListener {
    private final Color darkGray = new  Color(54,54,54);
    private final Color dimGray = new  Color(105,105,105);
    private final Color darkBlue = new  Color(0,0,205);
    public Keyboard(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 2;
        addButton("AC", darkGray, c, 0,0);
        c.gridwidth = 1;
        addButton("+/-", darkGray, c,2,0);
        addButton("/", darkBlue, c,3,0);

        addButton("7", dimGray, c,0,1);
        addButton("8", dimGray, c,1,1);
        addButton("9", dimGray, c,2,1);
        addButton("*", darkBlue, c,3,1);

        addButton("4", dimGray, c,0,2);
        addButton("5", dimGray, c,1,2);
        addButton("6", dimGray, c,2,2);
        addButton("-", darkBlue, c,3,2);

        addButton("1", dimGray, c,0,3);
        addButton("2", dimGray, c,1,3);
        addButton("3", dimGray, c,2,3);
        addButton("+", darkBlue, c,3,3);

        c.gridwidth = 2;
        addButton("0", dimGray, c,0,4);
        c.gridwidth = 1;
        addButton(",", dimGray, c,2,4);
        addButton("=", darkBlue, c,3,4);
    }

    private void addButton(String text, Color color, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        CustomButton customButton = new CustomButton(text,color);
        customButton.addActionListener(this);
        add(customButton,c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){
            JButton jButton = (JButton) e.getSource();
            Memory.getInstance().processCommand(jButton.getText());
        }
    }
}
