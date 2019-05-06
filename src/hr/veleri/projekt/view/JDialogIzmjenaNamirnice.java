/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.veleri.projekt.view;

import hr.veleri.projekt.controller.DBspajanje;
import hr.veleri.projekt.model.Namirnica;
import hr.veleri.projekt.model.NamirnicaNaObroku;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leon
 */
public class JDialogIzmjenaNamirnice extends javax.swing.JDialog {

    /**
     * Creates new form JDialogIzmjenaNamirnice
     */
    public JDialogIzmjenaNamirnice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prikaziNamirnice();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPromijeniNaziv = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOdabirNamirnice = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPromijeniNaziv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPromijeniNaziv.setText("Promijeni naziv");
        btnPromijeniNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniNazivActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        tableOdabirNamirnice.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tableOdabirNamirnice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naziv namirnice", "Energija (kcal)", "Šećeri (g)", "Masti (g)", "Bjelančevine (g)", "Odbitak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableOdabirNamirnice);
        if (tableOdabirNamirnice.getColumnModel().getColumnCount() > 0) {
            tableOdabirNamirnice.getColumnModel().getColumn(0).setMaxWidth(90);
        }
        modelOdabirNamirnica = (DefaultTableModel)tableOdabirNamirnice.getModel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Prijevod imena namirnica");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel17.setMaximumSize(new java.awt.Dimension(123, 82));
        jLabel17.setMinimumSize(new java.awt.Dimension(123, 82));
        jLabel17.setPreferredSize(new java.awt.Dimension(123, 82));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnPromijeniNaziv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOdustani)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPromijeniNaziv)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnPromijeniNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniNazivActionPerformed
        // TODO add your handling code here:
        int indexOdabraneNamirnice = tableOdabirNamirnice.getSelectedRow();
            if(indexOdabraneNamirnice>-1){
                Namirnica namirnica = new Namirnica();

                int idNamirnice = (Integer)modelOdabirNamirnica.getValueAt(indexOdabraneNamirnice, 0);
                namirnica.setId(idNamirnice);
                String naziv = (String)modelOdabirNamirnica.getValueAt(indexOdabraneNamirnice, 1);
                namirnica.setNaziv(naziv);
                DBspajanje.promjenaNazivaNamirnice(namirnica);
                prikaziNamirnice();
            }
    }//GEN-LAST:event_btnPromijeniNazivActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogIzmjenaNamirnice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogIzmjenaNamirnice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogIzmjenaNamirnice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogIzmjenaNamirnice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogIzmjenaNamirnice dialog = new JDialogIzmjenaNamirnice(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPromijeniNaziv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableOdabirNamirnice;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelOdabirNamirnica;
    
    private void prikaziNamirnice() {
        DefaultTableModel tableModel = (DefaultTableModel)tableOdabirNamirnice.getModel();
        tableModel.setRowCount(0);
        try {
        ArrayList<Namirnica> listaNamirnica = DBspajanje.ucitajNamirnice();
        for (Namirnica namirnica: listaNamirnica)
            tableModel.addRow(new Object[]{namirnica.getId(),namirnica.getNaziv(),namirnica.getEnergija(),
                namirnica.getSeceri(),namirnica.getMasti(),namirnica.getBjelancevine(),namirnica.getOdbitak()});

        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nema konekcije na bazu. Kontaktirajte administratora."
               ,"Greška kod dohvata kategorija", JOptionPane.ERROR_MESSAGE);    }
    }


}
