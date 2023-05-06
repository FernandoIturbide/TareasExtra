package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaGrid extends Frame{
    private Label label1;
    private Label label2;
    private TextField textField1;
    private TextField textField2;
    private Button button1;
    private GridLayout gridLayout;

    public VentanaGrid(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        gridLayout=new GridLayout(3,2);
        this.setLayout(gridLayout);
        label1=new Label("Etiqueta 1");
        this.add(label1,0);
        textField1=new TextField(30);
        this.add(textField1,1);
        label2=new Label("Etiqueta 2");
        this.add(label2,2);
        textField2=new TextField(30);
        this.add(textField2,3);
        button1=new Button("Presioname");
        this.add(button1,4);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String text=textField1.getText()+" "+textField2.getText();
                JOptionPane.showMessageDialog(null,text);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }
}

