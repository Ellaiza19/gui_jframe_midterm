
package mid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dashboard.class.getName());

   private String username;
   
    public dashboard() {
        initComponents();
        this.username = username;
        
        loadUserData();
        
    
    }
    
    private void loadUserData() {
    try {
        Connection conn = connectiondb.getConnection();

        String sql = "SELECT * FROM users"; // 
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("username"),
                rs.getString("password")               
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    
    System.out.println("Loading data...");
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2_update = new javax.swing.JButton();
        jButton3_delete = new javax.swing.JButton();
        jButton4_logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Downloads\\bg.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 160, 520);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jButton2_update.setText("Update");
        jButton2_update.addActionListener(this::jButton2_updateActionPerformed);

        jButton3_delete.setText("Delete");
        jButton3_delete.addActionListener(this::jButton3_deleteActionPerformed);

        jButton4_logout.setText("Logout");
        jButton4_logout.addActionListener(this::jButton4_logoutActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(jButton2_update)
                .addGap(26, 26, 26)
                .addComponent(jButton3_delete)
                .addGap(18, 18, 18)
                .addComponent(jButton4_logout)
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2_update)
                    .addComponent(jButton3_delete)
                    .addComponent(jButton4_logout))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(160, 0, 570, 110);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Lastname", "Firstname", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 150, 520, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_updateActionPerformed

        try {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a user first!");
            return;
        }

        String oldUsername = table.getValueAt(row, 0).toString();

        String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
        String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
        String newEmail = JOptionPane.showInputDialog(this, "Enter new email:");

        Connection conn = connectiondb.getConnection();

        String sql = "UPDATE users SET username=?, password=?, email=? WHERE username=?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, newUsername);
        pst.setString(2, newPassword);
        pst.setString(3, newEmail);
        pst.setString(4, oldUsername);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Updated successfully!");
        loadUserData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }


    }//GEN-LAST:event_jButton2_updateActionPerformed

    private void jButton3_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_deleteActionPerformed

        try {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a user first!");
            return;
        }

        String selectedUsername = table.getValueAt(row, 0).toString();

        // ❗ prevent deleting current logged-in account
        if (selectedUsername.equals(username)) {
            JOptionPane.showMessageDialog(this, "You cannot delete your own account!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete " + selectedUsername + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        Connection conn = connectiondb.getConnection();

        String sql = "DELETE FROM users WHERE username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, selectedUsername);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Deleted successfully!");
        loadUserData();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

             
    }//GEN-LAST:event_jButton3_deleteActionPerformed

    private void jButton4_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_logoutActionPerformed
        
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation",JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                this.dispose();
                
    new login().setVisible(true);
    this.dispose();
            }
                          
    }//GEN-LAST:event_jButton4_logoutActionPerformed

   
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_update;
    private javax.swing.JButton jButton3_delete;
    private javax.swing.JButton jButton4_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}
