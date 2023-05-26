package org.example.Controlador;

import org.example.Modelo.ModeloTablaLibro;
import org.example.Vista.VentanaLibro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorTabla extends MouseAdapter {
    private VentanaLibro view;
    private ModeloTablaLibro modelo;

    public ControladorTabla(VentanaLibro view) {
        this.view = view;
        this.view.getBtnCargar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.view.getBtnCargar()){
            modelo=new ModeloTablaLibro();
            modelo.CargarDatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();
        }
    }
}
