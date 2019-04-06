/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promax.Consulta;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import promax.FactPromax;
import promax.Forms.Menu;

/**
 *
 * @author aleja
 */
public class ConsultaFactura extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaFactura
     */
    public ConsultaFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.setSize(745, 352);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        
        refrescarCampos();
    }
    
    public void refrescarCampos(){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select f.id_factura, \n" +
                                       "c.nombre 'cliente',\n" +
                                       "e.nombre 'empleado',\n" +
                                       "p.nombre 'producto',\n" +
                                       "f.cantidad,\n" +
                                       "p.precio,\n" +
                                       "(p.precio*f.cantidad) 'total',\n" +
                                       "f.tipo_pago,\n" +
                                       "convert(varchar(10), f.fecha, 103) 'fecha'\n" +
                                       "from facturas f\n" +
                                       "join clientes c\n" +
                                       "on f.fk_id_cliente = c.id_cliente\n" +
                                       "join empleados e\n" +
                                       "on f.fk_id_empleado = e.id_empleado\n" +
                                       "join productos p\n" +
                                       "on f.fk_id_producto = p.id_producto\n");
        
        DefaultTableModel model = (DefaultTableModel) tblFactura.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[9];

            fila[0] = rs.getString("id_factura");
            fila[1] = rs.getString("cliente");
            fila[2] = rs.getString("empleado");
            fila[3] = rs.getString("producto");
            fila[4] = rs.getString("cantidad");
            fila[5] = rs.getString("precio");
            fila[6] = rs.getString("total");
            fila[7] = rs.getString("tipo_pago");
            fila[8] = rs.getString("fecha");
            
            model.addRow(fila);
        }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
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
        Salir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        Atras = new javax.swing.JLabel();
        Siguiente = new javax.swing.JLabel();
        cbFacturas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(30, 130, 76));

        Salir.setBackground(new java.awt.Color(255, 255, 255));
        Salir.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("X");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar Facturas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por:");

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/promax/Imgs/L-arrow.png"))); // NOI18N
        Atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtrasMouseClicked(evt);
            }
        });

        Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/promax/Imgs/R-arrow.png"))); // NOI18N
        Siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SiguienteMouseClicked(evt);
            }
        });

        cbFacturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:", "Cliente", "Empleado", "Producto", "Cantidad", "Tipo pago" }));

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cliente", "Empleado", "Producto", "Cantidad", "Precio", "Total", "Tipo pago", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tblFactura);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(9, 9, 9)
                        .addComponent(Atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Siguiente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Atras)
                        .addComponent(Siguiente)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int rs = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?","Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(rs == 0){
            this.dispose();
            Menu mn = new Menu();
            mn.setVisible(true);
        }
    }//GEN-LAST:event_SalirMouseClicked

    private void AtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasMouseClicked
        ConsultaProveedor mf = new ConsultaProveedor();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AtrasMouseClicked

    private void SiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteMouseClicked
        ConsultaCliente mf = new ConsultaCliente();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SiguienteMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String valor="";
        if(cbFacturas.getSelectedIndex()==1){
            valor ="c.nombre";
        }else if(cbFacturas.getSelectedIndex()==2){
           valor ="e.nombre"; 
        }
        else if(cbFacturas.getSelectedIndex()==3){
           valor ="p.nombre"; 
        }
        else if(cbFacturas.getSelectedIndex()==4){
           valor ="f.cantidad"; 
        }
        else if(cbFacturas.getSelectedIndex()==5){
           valor ="f.tipo_pago"; 
        }
        FactPromax.consultaFactura(txtBuscar.getText(), valor, tblFactura);

    }//GEN-LAST:event_btnBuscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Atras;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel Siguiente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbFacturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
