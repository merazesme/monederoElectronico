/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaAbonos;
import vista.vistaBase;
import vista.vistaCargos;
import vista.vistaClientes;
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
    vistaProductos vistaProductos = new vistaProductos();
    
    public controlBase(vistaBase vista)
    {
        this.vista=vista;
        this.vista.btnCargos.addActionListener(this);
        this.vista.btnAbonos.addActionListener(this);
        this.vista.btnCliente.addActionListener(this);
        this.vista.btnProductos.addActionListener(this);
        this.vista.btnRegalo.addActionListener(this);
    }
    
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
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
            controlAbonos controlAbonos = new controlAbonos(vistaAbonos);
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
        if(vista.btnProductos == e.getSource())
        {
            CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaProductos);
            controlProductos controlProductos = new controlProductos(vistaProductos);
            controlProductos.iniciarVista();
        }
    }
    
}
