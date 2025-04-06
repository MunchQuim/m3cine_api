/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.gui;

import view.console.Main;
import model.Room;
import model.Cine;
import javax.swing.JOptionPane;

/**
 *
 * @author victorhidsan
 */
public class NewJFrameSala extends javax.swing.JFrame {

    private final Cine cine = Cine.getInstance(); // Use singleton instance

    /**
     * Creates new form NewJFrameSala
     */
    public NewJFrameSala() {
        initComponents();
        updateLabels();
    }
    
    private void updateLabels() {
        // Update labels to include the maximum number of seats
        salaLabelNormales.setText("Asientos Normales (máx. 50):");
        salaLabelVip.setText("Asientos VIP (máx. 50):");
        salaLabelAdaptados.setText("Asientos Adaptados (máx. 50):");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSala = new javax.swing.JPanel();
        guardarSala = new javax.swing.JButton();
        limpiarSala = new javax.swing.JButton();
        salaFieldNum = new javax.swing.JTextField();
        salaLabelNum = new javax.swing.JLabel();
        salaFieldNormales = new javax.swing.JTextField();
        salaLabelNormales = new javax.swing.JLabel();
        salaFieldVip = new javax.swing.JTextField();
        salaLabelVip = new javax.swing.JLabel();
        salaFieldAdaptados = new javax.swing.JTextField();
        salaLabelAdaptados = new javax.swing.JLabel();
        volverAdminButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        guardarSala.setText("Guardar");
        guardarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarSalaActionPerformed(evt);
            }
        });

        limpiarSala.setText("Limpiar");
        limpiarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarSalaActionPerformed(evt);
            }
        });

        salaLabelNum.setText("Numero de Sala:");

        salaLabelNormales.setText("Asientos Normales:");

        salaLabelVip.setText("Asientos VIP:");

        salaLabelAdaptados.setText("Asientos Adaptados:");

        volverAdminButton.setText("Volver al Admin");
        volverAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAdminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSalaLayout = new javax.swing.GroupLayout(panelSala);
        panelSala.setLayout(panelSalaLayout);
        panelSalaLayout.setHorizontalGroup(
            panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSalaLayout.createSequentialGroup()
                        .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salaLabelNum)
                            .addComponent(salaLabelNormales)
                            .addComponent(salaLabelVip)
                            .addComponent(salaLabelAdaptados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salaFieldNum)
                            .addComponent(salaFieldNormales)
                            .addComponent(salaFieldVip)
                            .addComponent(salaFieldAdaptados, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addGroup(panelSalaLayout.createSequentialGroup()
                        .addComponent(guardarSala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiarSala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volverAdminButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSalaLayout.setVerticalGroup(
            panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaLabelNum))
                .addGap(18, 18, 18)
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaFieldNormales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaLabelNormales))
                .addGap(18, 18, 18)
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaFieldVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaLabelVip))
                .addGap(18, 18, 18)
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaFieldAdaptados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaLabelAdaptados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarSala)
                    .addComponent(limpiarSala)
                    .addComponent(volverAdminButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(panelSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(panelSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarSalaActionPerformed
        String numSala = salaFieldNum.getText();
        String normalesStr = salaFieldNormales.getText();
        String vipStr = salaFieldVip.getText();
        String adaptadosStr = salaFieldAdaptados.getText();
        
        if (numSala.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El número de sala no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cine.isRoomNumberUsed(numSala)) { // Use direct Cine instance
            JOptionPane.showMessageDialog(this, "El número de sala ya está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int normales;
        int vip;
        int adaptados;
        
        try {
            normales = Integer.parseInt(normalesStr);
            if (normales < 0 || normales > 50) {
                JOptionPane.showMessageDialog(this, "Número de asientos normales debe estar entre 0 y 50.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de asientos normales no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            vip = Integer.parseInt(vipStr);
            if (vip < 0 || vip > 50) {
                JOptionPane.showMessageDialog(this, "Número de asientos VIP debe estar entre 0 y 50.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de asientos VIP no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            adaptados = Integer.parseInt(adaptadosStr);
            if (adaptados < 0 || adaptados > 50) {
                JOptionPane.showMessageDialog(this, "Número de asientos adaptados debe estar entre 0 y 50.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de asientos adaptados no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create room and add to Cine
        Room room = new Room(numSala, normales, vip, adaptados);
        cine.setRooms(room); // Use Cine's method to add the room
        
        JOptionPane.showMessageDialog(this, "Sala creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Clear fields
        limpiarSalaActionPerformed(evt);
    }//GEN-LAST:event_guardarSalaActionPerformed

    private void limpiarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarSalaActionPerformed
        salaFieldNum.setText("");
        salaFieldNormales.setText("");
        salaFieldVip.setText("");
        salaFieldAdaptados.setText("");
    }//GEN-LAST:event_limpiarSalaActionPerformed

    private void volverAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAdminButtonActionPerformed
        NewJFrameAdmin newJFrameAdmin = new NewJFrameAdmin();
        newJFrameAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverAdminButtonActionPerformed

    private void salaFieldNumSalaActionPerformed(java.awt.event.ActionEvent evt) {
        // Method stub
    }

    private void salaFieldNumAsientosNormalesActionPerformed(java.awt.event.ActionEvent evt) {
        // Method stub
    }

    private void salaFieldNumAsientosVIPActionPerformed(java.awt.event.ActionEvent evt) {
        // Method stub
    }

    private void salaFieldNumAsientosAdaptadosActionPerformed(java.awt.event.ActionEvent evt) {
        // Method stub
    }

    private void VolverAdminActionPerformed(java.awt.event.ActionEvent evt) {
        NewJFrameAdmin newJFrameAdmin = new NewJFrameAdmin();
        newJFrameAdmin.setVisible(true);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(NewJFrameSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarSala;
    private javax.swing.JButton limpiarSala;
    private javax.swing.JPanel panelSala;
    private javax.swing.JTextField salaFieldAdaptados;
    private javax.swing.JTextField salaFieldNormales;
    private javax.swing.JTextField salaFieldNum;
    private javax.swing.JTextField salaFieldVip;
    private javax.swing.JLabel salaLabelAdaptados;
    private javax.swing.JLabel salaLabelNormales;
    private javax.swing.JLabel salaLabelNum;
    private javax.swing.JLabel salaLabelVip;
    private javax.swing.JButton volverAdminButton;
    // End of variables declaration//GEN-END:variables
}
