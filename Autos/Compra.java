/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.Venta.getConection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leolugo
 */
public class Compra extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/hospital";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection(){
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
    
    public Compra() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtClave.enable();
    }

    private void limpiarCaja(){
        txtClave.setText(null);
        txtIdP.setText(null);
        txtTC.setText(null);
        txtFC.setText(null);
    }
    private void guardarDatos() throws SQLException{
        
       Connection con = null;
        
        
        try {
            con = getConection();
           
            ps = con.prepareStatement("insert into compra (Clave, Id_Proveedor, TotalCompra, FechaCompra) values (?, ?, ?, ?)");
            ps.setString(1, txtClave.getText());
            ps.setString(2, txtIdP.getText());  
            ps.setInt(3, Integer.parseInt(txtTC.getText()));           
            ps.setString(4, txtFC.getText());
            
            
                               
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "La Compra se registro con éxito!");
                limpiarCaja();
            }else{
               JOptionPane.showMessageDialog(null, "Hubo un error al guardar!"); 
               
            }
            
            con.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
    }
    
    public void eliminarDatos(){
        Connection con = null;
        try {
            con = getConection();
            
            ps = con.prepareStatement("delete from compra where Clave = ?");
            ps.setString(1, txtClave.getText());
            int res = ps.executeUpdate();
            if (res > 0) {
              JOptionPane.showMessageDialog(null, "Se elimino la compra con clave: "+txtClave.getText() + " de forma exitosa!"); 
              limpiarCaja();
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar!"); 
            }
            
            con.close();
            
        } catch (Exception e) {
        }
    }
    
    public void buscarDatos(){
         Connection con = null;
        try {
            con = getConection();
            
            ps = con.prepareStatement("select * from compra where Clave =?");
            ps.setString(1, txtClave.getText());
           
            rs = ps.executeQuery();
          
            if (rs.next() ) {
              txtIdP.setText(rs.getString("Id_Proveedor"));  
              txtTC.setText(Integer.toString(rs.getInt("TotalCompra")));     
              txtFC.setText(rs.getString("FechaCompra"));  
              
                       
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al buscar!"); 
            }
            
            con.close();
            
        } catch (Exception e) {
        }
        
        
    }

    public void modificarDatos(){
         Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement("update compra set Clave=?, Id_Proveedor=?, TotalCompra=?, FechaCompra=?");
            ps.setString(1, txtClave.getText());
            ps.setString(2, txtIdP.getText());
            ps.setString(3, txtTC.getText());          
            ps.setString(4, txtFC.getText());
           
           int res = ps.executeUpdate();
          
            if (res>0 ) {
              JOptionPane.showMessageDialog(null, "Compra Modificada");
              limpiarCaja();
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al Modificar la Compra"); 
                limpiarCaja();
            }
            
            con.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtClave = new javax.swing.JTextField();
        txtIdP = new javax.swing.JTextField();
        txtFC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnEmpleado = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTC = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMPRA");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtClave.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 60, 30));

        txtIdP.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jPanel1.add(txtIdP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 210, 30));

        txtFC.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jPanel1.add(txtFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 210, 30));

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel7.setText("Clave:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel6.setText("Compra");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel8.setText("Id_Proveedor:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel10.setText("Fecha Compra:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        btnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compra.png"))); // NOI18N
        btnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseClicked(evt);
            }
        });
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 220, 210));

        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel11.setText("Total Compra:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txtTC.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jPanel1.add(txtTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 210, 30));

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 170, 30));

        btnModificar.setBackground(new java.awt.Color(102, 102, 102));
        btnModificar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 170, 30));

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 170, 30));

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 170, 30));

        btnCrear.setBackground(new java.awt.Color(102, 102, 102));
        btnCrear.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 170, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Paciente.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseClicked
        MenuCompra e = new MenuCompra();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadoMouseClicked

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        MenuCompra e = new MenuCompra();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            modificarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            eliminarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCaja();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            guardarDatos();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtFC;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtTC;
    // End of variables declaration//GEN-END:variables
}
