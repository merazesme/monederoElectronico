/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Holi
 */
public class vistaCargos extends javax.swing.JPanel {

    /**
     * Creates new form vistaCargos
     */
    public vistaCargos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSucursalN = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnMovimientos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblClienteN = new javax.swing.JLabel();
        lblProducto1 = new javax.swing.JLabel();
        lblProductoN = new javax.swing.JLabel();
        lblSucursal1 = new javax.swing.JLabel();
        lblPuntosN = new javax.swing.JLabel();
        lblProductoa1 = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(524, 419));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Número de cliente");

        lblSucursalN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblSucursalN.setForeground(new java.awt.Color(102, 102, 102));
        lblSucursalN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSucursalN.setText("#");

        txtCliente.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(51, 51, 51));
        txtCliente.setBorder(null);

        btnFinalizar.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Card_Payment_40px.png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setContentAreaFilled(false);
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.setDefaultCapable(false);
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Card_Payment_35px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Cargos");

        lblHora.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(102, 102, 102));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHora.setText("Hora: 00:00");

        lblFecha.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha.setText("dd/mm/yyyy ");

        btnMovimientos.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Ledger_45px.png"))); // NOI18N
        btnMovimientos.setText("Movimientos");
        btnMovimientos.setBorderPainted(false);
        btnMovimientos.setContentAreaFilled(false);
        btnMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMovimientos.setDefaultCapable(false);
        btnMovimientos.setFocusPainted(false);
        btnMovimientos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Ledger_40px.png"))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        lblClienteN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblClienteN.setForeground(new java.awt.Color(102, 102, 102));
        lblClienteN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClienteN.setText("Cliente");

        lblProducto1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblProducto1.setForeground(new java.awt.Color(102, 102, 102));
        lblProducto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProducto1.setText("Puntos Acumulados:");

        lblProductoN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblProductoN.setForeground(new java.awt.Color(102, 102, 102));
        lblProductoN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblSucursal1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblSucursal1.setForeground(new java.awt.Color(102, 102, 102));
        lblSucursal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal1.setText("Sucursal no. ");

        lblPuntosN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblPuntosN.setForeground(new java.awt.Color(102, 102, 102));
        lblPuntosN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPuntosN.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblProductoa1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblProductoa1.setForeground(new java.awt.Color(102, 102, 102));
        lblProductoa1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProductoa1.setText("Producto a canjear:");

        lblFecha1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        lblFecha1.setForeground(new java.awt.Color(102, 102, 102));
        lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha1.setText("Fecha: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(lblProducto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuntosN, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 244, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClienteN, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblProductoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblProductoN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMovimientos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinalizar))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblFecha1)
                                .addGap(2, 2, 2)
                                .addComponent(lblFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSucursal1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSucursalN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSucursalN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSucursal1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPuntosN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClienteN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblProductoN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFinalizar)
                        .addComponent(btnMovimientos))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFinalizar;
    public javax.swing.JButton btnMovimientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblClienteN;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblFecha1;
    public javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblProducto1;
    public javax.swing.JLabel lblProductoN;
    public javax.swing.JLabel lblProductoa1;
    public javax.swing.JLabel lblPuntosN;
    public javax.swing.JLabel lblSucursal1;
    public javax.swing.JLabel lblSucursalN;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
