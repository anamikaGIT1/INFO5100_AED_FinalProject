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
public class ManageHRJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageHRJpanel
     */
    public ManageHRJpanel() {
        initComponents();
        showdata();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hrName = new javax.swing.JTextField();
        hrAddress = new javax.swing.JTextField();
        hrUserName = new javax.swing.JTextField();
        hrPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        hrID = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Manage HR");

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

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("User Name");

        jLabel6.setText("Password");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        hrID.setEditable(false);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hrName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hrAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(hrPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(hrUserName, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(hrID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton1)
                        .addGap(79, 79, 79)
                        .addComponent(update)
                        .addGap(82, 82, 82)
                        .addComponent(delete)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hrID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hrAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hrUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(hrPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(update)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showdata(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement show= Con.prepareStatement("select * from HR_Dir");
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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement add= Con.prepareStatement("insert into HR_Dir(HRName,HRAddress,HrUser,Password) values(?,?,?,?)");
            add.setString(1, hrName.getText());
            add.setString(2, hrAddress.getText());
            add.setString(3,hrUserName.getText());
            add.setString(4,hrPassword.getText());
            int row=add.executeUpdate();
            showdata();
            PreparedStatement add1= Con.prepareStatement("insert into Credentials values(?,?,?)");
            add1.setString(1, hrUserName.getText());
            add1.setString(2, hrPassword.getText());
            add1.setString(3, "HR");
            int row1=add1.executeUpdate();
            JOptionPane.showMessageDialog(this, "HR Added Successfully");
            hrName.setText("");
            hrAddress.setText("");
            hrUserName.setText("");
            hrPassword.setText("");
            Con.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        hrID.setText((String)model.getValueAt(row, 0));
        hrName.setText((String)model.getValueAt(row, 1));
        hrAddress.setText((String)model.getValueAt(row, 2));
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String id = hrID.getText();
        String name = hrName.getText();
        String address= hrAddress.getText();
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement upd= Con.prepareStatement("Update HR_Dir Set HRName = '" + name +"' , HRAddress = '" +address + "' where HRID = '" + id + "'");
            upd.executeUpdate();
            JOptionPane.showMessageDialog(this, "HR Updated Successfully");
            hrID.setText("");
            hrName.setText("");
            hrAddress.setText("");
            showdata();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String id = hrID.getText();
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement upd= Con.prepareStatement("Delete from HR_Dir where HRID = '" + id + "'");
            upd.executeUpdate();
            hrID.setText("");
            hrName.setText("");
            hrAddress.setText("");
            showdata();
            JOptionPane.showMessageDialog(this, "HR Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField hrAddress;
    private javax.swing.JTextField hrID;
    private javax.swing.JTextField hrName;
    private javax.swing.JTextField hrPassword;
    private javax.swing.JTextField hrUserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
