/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LoginPackage;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anweshsingh
 */
public class ManageJMJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageJMJpanel
     */
    public ManageJMJpanel() {
        initComponents();
        showdata();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jmName = new javax.swing.JTextField();
        jmAddress = new javax.swing.JTextField();
        jmUserName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jmPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jmID = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Manage Job Managers");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Name");

        jLabel5.setText("Address");

        jLabel6.setText("User Name");

        btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel7.setText("Password");

        jLabel3.setText("ID");

        jmID.setEditable(false);

        update.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jmAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jmName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(jmUserName, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jmID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jmID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jmAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jmUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(update)
                    .addComponent(delete))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showdata(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement show= Con.prepareStatement("select * from JM_Dir");
            ResultSet Rs = show.executeQuery();
            ResultSetMetaData rsmd = Rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            int cols = rsmd.getColumnCount();
            String [] colName = new String[cols];
            String id,name,address;
            while (Rs.next()){
                id=Rs.getString(1);
                name=Rs.getString(2);
                address=Rs.getString(3);
                String[] row = {id,name,address};
                model.addRow(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }   
        
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement add= Con.prepareStatement("insert into JM_Dir(JMName,JMAddress,JMUser,Password) values(?,?,?,?)");
            add.setString(1, jmName.getText());
            add.setString(2, jmAddress.getText());
            add.setString(3,jmUserName.getText());
            add.setString(4,jmPassword.getText());
            int row=add.executeUpdate();
            showdata();
            PreparedStatement add1= Con.prepareStatement("insert into Credentials values(?,?,?)");
            add1.setString(1, jmUserName.getText());
            add1.setString(2, jmPassword.getText());
            add1.setString(3, "Job Manager");
            int row1=add1.executeUpdate();
            JOptionPane.showMessageDialog(this, "Job Manager Added Successfully");
            jmName.setText("");
            jmAddress.setText("");
            jmUserName.setText("");
            jmPassword.setText("");
            Con.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        jmID.setText((String)model.getValueAt(row, 0));
        jmName.setText((String)model.getValueAt(row, 1));
        jmAddress.setText((String)model.getValueAt(row, 2));
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String id = jmID.getText();
        String name = jmName.getText();
        String address= jmAddress.getText();
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement upd= Con.prepareStatement("Update JM_Dir Set JMName = '" + name +"' , JMAddress = '" +address + "' where JMID = '" + id + "'");
            upd.executeUpdate();
            jmID.setText("");
            jmName.setText("");
            jmAddress.setText("");
            showdata();
            JOptionPane.showMessageDialog(this, "Job Manager Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String id = jmID.getText();
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement upd= Con.prepareStatement("Delete from JM_Dir where JMID = '" + id + "'");
            upd.executeUpdate();
            jmID.setText("");
            jmName.setText("");
            jmAddress.setText("");
            showdata();
            JOptionPane.showMessageDialog(this, "Job Manager Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jmAddress;
    private javax.swing.JTextField jmID;
    private javax.swing.JTextField jmName;
    private javax.swing.JTextField jmPassword;
    private javax.swing.JTextField jmUserName;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
