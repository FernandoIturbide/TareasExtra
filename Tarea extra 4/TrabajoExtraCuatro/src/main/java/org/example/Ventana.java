package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonPanel1;
    private JLabel etiquetaPanel1;
    private JPanel panel2;
    private JLabel etiquetaPanel2;
    private JPanel panel3;
    private JComboBox comboPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //panel1
        panel1= new JPanel();
        panel1.setBackground(new Color(221,237,250));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        botonPanel1=new JButton("Presioname!!!!!");
        panel1.add(botonPanel1);
        etiquetaPanel1=new JLabel(".....");
        panel1.add(etiquetaPanel1);
        botonPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiquetaPanel1.setText("Hola, presionaste el boton del panel 1");
            }
        });
        this.getContentPane().add(panel1,0);
        //Panel2
        String urlImagen="https://th.bing.com/th/id/OIP.JcPIO4PlaC4kQSeM0sZGkQAAAA?pid=ImgDet&rs=1";
        panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.setBackground(new Color(250,224,221));
        panel2.setLayout(new FlowLayout());
        try {
            URL url=new URL(urlImagen);
            Image imagen = ImageIO.read(url);
            ImageIcon imageIcon=new ImageIcon(imagen);
            etiquetaPanel2=new JLabel(imageIcon);
            panel2.add(etiquetaPanel2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException Me){
            System.out.println("URL no valida");
        }catch (Exception e){
            System.out.println("Error al cargar de la red");
        }


        //panel3
        panel3=new JPanel();
        panel3.setBackground(new Color(231,221,250));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos={"Opcion 1","Opcion 2","Opcion 3","Opcion 4"};
        comboPanel3=new JComboBox<>(elementos);
        comboPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource().toString());
                System.out.println(comboPanel3.getSelectedIndex());
            }
        });
        panel3.add(comboPanel3);
        this.getContentPane().add(panel3,2);

        //panel4
        panel4=new JPanel();
        panel4.setBackground(new Color(222,245,204));
        this.getContentPane().add(panel4,3);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
