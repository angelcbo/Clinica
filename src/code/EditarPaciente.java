/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Conexion.Conexion;
/**
 *
 * @author Angel
 */
public class EditarPaciente extends javax.swing.JDialog {

    /**
     * Creates new form EditarPaciente
     */
    public EditarPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Pagina Principal");
        this.setSize(665, 440);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_domicilio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel1.setText("Numero de Paciente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 100, 170, 30);

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(200, 100, 180, 30);

        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 150, 80, 23);

        btn_buscar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar);
        btn_buscar.setBounds(400, 100, 90, 27);

        jButton2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 320, 110, 30);

        jButton3.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(170, 320, 110, 30);
        getContentPane().add(txt_nombre);
        txt_nombre.setBounds(200, 150, 300, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 48)); // NOI18N
        jLabel4.setText("Editar Paciente");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 10, 350, 40);

        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel6.setText("Domicilio:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 200, 100, 30);

        txt_domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_domicilioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_domicilio);
        txt_domicilio.setBounds(200, 200, 300, 30);

        jLabel7.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel7.setText("Telefono:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 260, 90, 20);
        getContentPane().add(txt_telefono);
        txt_telefono.setBounds(200, 250, 300, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/535813fc9bbdd54.JPG"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 650, 400);

        jLabel5.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 150, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        String id = txt_id.getText();
        String consulta = "SELECT * FROM "+Conexion.tblpacientes+" WHERE "
                           +" pac_id="+id;
        
        try{
        
             //obtener conexion:
                Connection conn = Conexion.getConnection();
                PreparedStatement query = conn.prepareStatement(consulta);
                ResultSet rs = query.executeQuery();

                if(rs.next()){
                    
                 txt_nombre.setText(rs.getString("pac_nombre"));
                 txt_domicilio.setText(rs.getString("pac_direccion"));
                 txt_telefono.setText(rs.getString("pac_telefono"));
                 
                    
                }else{
                    JOptionPane.showMessageDialog(null,"No se encontro al paciente");
                }
            
            
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error Editar->"+e);
            
        }//catch
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_domicilioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id = txt_id.getText();
        String nombre = txt_nombre.getText();
        String domicilio = txt_domicilio.getText();
        String telefono = txt_telefono.getText();
        try{
            
    String consulta = "UPDATE " + Conexion.tblpacientes +" SET "
                    + " pac_nombre='"+nombre+"', "
                    + "pac_direccion='"+domicilio+"', "
                    + "pac_telefono='"+telefono+"' "
                    
                    + " WHERE pac_id="+id;
                    
            //obtener conexion:
            Connection conn = Conexion.getConnection();
            PreparedStatement query = conn.prepareStatement(consulta);
            int filas = query.executeUpdate();
           
            if(filas>0){
                JOptionPane.showMessageDialog(null,"Cambio realizado");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"No se hicieron cambios");
            } /*//else */
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error en la conexion: "+e);
        }//catch 
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarPaciente dialog = new EditarPaciente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_domicilio;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
