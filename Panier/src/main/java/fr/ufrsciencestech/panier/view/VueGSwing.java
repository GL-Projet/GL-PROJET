/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import java.awt.event.ActionListener;

/**
 *
 * @author HP
 */
public class VueGSwing extends javax.swing.JFrame {

    /**
     * Creates new form VueGSwing
     */
    public VueGSwing() {
        initComponents();
        this.desactiverButtonMoins();
    }
    
    private ActionListener buttonPlusListener;
    private ActionListener buttonMoinsListener;
    
    //pour le clic sur le button plus
    public void addButtonPlusListener(ActionListener listener) {
        this.buttonPlusListener = listener;
    }
    
    public void desactiverButtonPlus (){
        this.Buttonplus.setEnabled(false);
    }
    public void activerButtonPlus (){
        this.Buttonplus.setEnabled(true);
    }
    
    //modification du jlabel compteur
    public void setCompteur(String text) {
        Compteur.setText(text);
    }
    
    //pour le clic sur le button moins
    public void addButtonMoinsListener(ActionListener listener) {
        this.buttonMoinsListener = listener;
    }
    
    public void desactiverButtonMoins (){
        this.Buttonmoins.setEnabled(false);
    }
    public void activerButtonMoins () {
        this.Buttonmoins.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buttonplus = new javax.swing.JButton();
        Compteur = new javax.swing.JLabel();
        Buttonmoins = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panier");
        setPreferredSize(new java.awt.Dimension(250, 150));

        Buttonplus.setText("+");
        Buttonplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonplusActionPerformed(evt);
            }
        });
        getContentPane().add(Buttonplus, java.awt.BorderLayout.NORTH);

        Compteur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Compteur, java.awt.BorderLayout.CENTER);

        Buttonmoins.setText("-");
        Buttonmoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonmoinsActionPerformed(evt);
            }
        });
        getContentPane().add(Buttonmoins, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //le clic sur le bouton  plus
    private void ButtonplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonplusActionPerformed
        // TODO add your handling code here:
        if(buttonPlusListener != null) {
            buttonPlusListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_ButtonplusActionPerformed

    //le clic sur le bouton moins
    private void ButtonmoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonmoinsActionPerformed
        // TODO add your handling code here:
        if(buttonMoinsListener != null) {
            buttonMoinsListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_ButtonmoinsActionPerformed

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
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueGSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttonmoins;
    private javax.swing.JButton Buttonplus;
    private javax.swing.JLabel Compteur;
    // End of variables declaration//GEN-END:variables
}
