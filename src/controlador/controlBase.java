/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloAbonos;
import vista.vistaAbonos;
import vista.vistaBase;
import vista.vistaCargos;
import vista.vistaClientes;
import vista.vistaEmpleados;
import vista.vistaPremios;
import vista.vistaProductos;

/**
 *
 * @author Holi
 */
public class controlBase implements ActionListener{

    vistaBase vista;
    vistaCargos vistaCargos = new vistaCargos();
    vistaAbonos vistaAbonos = new vistaAbonos();
    vistaClientes vistaClientes = new vistaClientes();
    vistaPremios vistaPremios = new vistaPremios();
    vistaEmpleados vistaEmpleados = new vistaEmpleados();
    
    public controlBase(vistaBase vista)
    {
        this.vista=vista;
        this.vista.btnCargos.addActionListener(this);
        this.vista.btnAbonos.addActionListener(this);
        this.vista.btnCliente.addActionListener(this);
        this.vista.btnEmpleados.addActionListener(this);
        this.vista.btnRegalo.addActionListener(this);
    }
    
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.btnAbonos.setEnabled(false);
        this.vista.btnCargos.setEnabled(false);
        this.vista.btnCliente.setEnabled(false);
        this.vista.btnEmpleados.setEnabled(false);
        this.vista.btnRegalo.setEnabled(false);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            
        if(vista.btnCargos == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaCargos);
            controlCargos controlCargos = new controlCargos(vistaCargos);
            controlCargos.iniciarVista();
        }
        if(vista.btnAbonos == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaAbonos);
            modeloAbonos modeloAbonos = new modeloAbonos();
            controlAbonos controlAbonos = new controlAbonos(vistaAbonos, modeloAbonos);
            controlAbonos.iniciarVista();
        }
        if(vista.btnCliente == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaClientes);
            controlClientes controlClientes = new controlClientes(vistaClientes);
            controlClientes.iniciarVista();
        }
        if(vista.btnRegalo == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaPremios);
            controlPremios controlPremios = new controlPremios(vistaPremios);
            controlPremios.iniciarVista();
        }
        if(vista.btnEmpleados == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaEmpleados);
            controlEmpleados controlEmpleados = new controlEmpleados(vistaEmpleados);
            controlEmpleados.iniciarVista();
        }
    }
    
}
